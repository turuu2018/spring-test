package mn.turuu.springtest.controller.account;

import mn.turuu.springtest.controller.BaseController;
import mn.turuu.springtest.form.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private BaseController baseController;

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("login");
        baseController.init(mav);

        mav.addObject("loginForm", new LoginForm());
        return mav;
    }

    @RequestMapping(value = {"/logout"}, method = RequestMethod.GET)
    public ModelAndView logout() {
        return login();
    }
}
