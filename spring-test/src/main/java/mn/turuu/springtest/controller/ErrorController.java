package mn.turuu.springtest.controller;

import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author PDBD
 */
@Controller
public class ErrorController {

    private static final Logger LOGGER = Logger.getLogger(ErrorController.class.getName());

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String index() {
        LOGGER.info(">>> error controller");
        return "error";
    }
}
