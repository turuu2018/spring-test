package mn.turuu.springtest.controller;

import java.util.logging.Logger;
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
public class ErrorController {

    private static final Logger LOGGER = Logger.getLogger(ErrorController.class.getName());

    @Autowired
    private BaseController baseController;

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public ModelAndView error() {
        ModelAndView mav = new ModelAndView("error");
        baseController.init(mav);
        //LOGGER.info(">>> error controller");
        return mav;
    }
}
