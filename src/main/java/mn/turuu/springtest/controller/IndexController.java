package mn.turuu.springtest.controller;

import java.util.Date;
import java.util.logging.Logger;
import mn.turuu.springtest.model.UserData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author PDBD
 */
@RequestMapping("/")
@Controller
public class IndexController {

    private static final Logger LOGGER = Logger.getLogger(IndexController.class.getName());

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public ModelAndView index() {
        LOGGER.info(">>> index controller");
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("user", "test-user");
        mav.addObject("userData", new UserData("Turuu", new Date()));
        return mav;
    }
}
