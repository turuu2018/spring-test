package mn.turuu.springtest.controller;

import java.util.logging.Logger;
import mn.turuu.springtest.dao.UserDAO;
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
public class IndexController {

    private static final Logger LOGGER = Logger.getLogger(IndexController.class.getName());

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private BaseController baseController;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public ModelAndView index() {
        LOGGER.info(">>> index controller");
        ModelAndView mav = new ModelAndView("index");
        baseController.init(mav);

        mav.addObject("users", userDAO.list(null));
        return mav;
    }
}
