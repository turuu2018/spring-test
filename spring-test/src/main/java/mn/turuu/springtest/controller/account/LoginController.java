package mn.turuu.springtest.controller.account;

import mn.turuu.springtest.form.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author PDBD
 */
@Controller
public class LoginController {

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("loginForm", new LoginForm());
        return mav;
    }

    @RequestMapping(value = {"/logout"}, method = RequestMethod.GET)
    public void logout() {
    }
}
