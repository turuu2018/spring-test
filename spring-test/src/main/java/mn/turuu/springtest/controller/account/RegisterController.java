package mn.turuu.springtest.controller.account;

import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import javax.validation.Valid;
import mn.turuu.springtest.dao.UserDAO;
import mn.turuu.springtest.form.RegisterForm;
import mn.turuu.springtest.model.User;
import mn.turuu.springtest.model.UserRole;
import mn.turuu.springtest.model.UserRoleId;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author PDBD
 */
@Controller
public class RegisterController {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MessageSource messageSource;

    @ModelAttribute
    public RegisterForm initRegisterForm() {
        return new RegisterForm();
    }

    @RequestMapping(value = {"/register"}, method = RequestMethod.GET)
    public ModelAndView register(@ModelAttribute RegisterForm registerForm) {
        ModelAndView mav = new ModelAndView("register");
        mav.addObject("registerForm", registerForm);
        return mav;
    }

    @RequestMapping(value = {"/register"}, method = RequestMethod.POST)
    public ModelAndView registerPost(@ModelAttribute @Valid RegisterForm registerForm,
            BindingResult bindingResult, Locale locale) {
        ModelAndView mav;

        if (!Objects.equals(registerForm.getPassword1(), registerForm.getPassword2())) {
            bindingResult.reject("password2", "Passwords do not match!");
        }
        if (userDAO.get(registerForm.getUsername()) != null) {
            bindingResult.reject("username", messageSource.getMessage("username.exist", null, locale));
        }

        /*for (FieldError fe: bindingResult.getFieldErrors()) {
            System.out.println(fe.getField() + " - " + fe.getRejectedValue());
        }*/
        if (bindingResult.hasErrors()) {
            mav = register(registerForm);
        } else {
            // fegister user
            Session session = null;
            Transaction transaction = null;
            try {
                session = sessionFactory.openSession();
                transaction = session.beginTransaction();

                User user = new User();
                user.setUsername(registerForm.getUsername());
                user.setPassword(passwordEncoder.encode(registerForm.getPassword1()));
                user.setRegisteredDate(new Date());
                user.setLastName(registerForm.getLastName());
                user.setFirstName(registerForm.getFirstName());
                session.save(user);

                UserRole userRole = new UserRole();
                userRole.setId(new UserRoleId(user.getId(), "ROLE_USER"));
                userRole.setUser(user);
                session.save(userRole);

                transaction.commit();
                //session.flush();

                mav = new ModelAndView("register-activate");
            } catch (HibernateException e) {
                if (transaction != null) {
                    transaction.rollback();
                }

                bindingResult.reject("username", "Database error!");
                mav = register(registerForm);
            } finally {
                if (session != null) {
                    try {
                        session.close();
                    } catch (HibernateException e) {
                    }
                }
            }
        }

        return mav;
    }
}
