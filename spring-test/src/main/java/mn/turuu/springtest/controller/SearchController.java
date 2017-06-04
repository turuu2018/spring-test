package mn.turuu.springtest.controller;

import mn.turuu.springtest.dao.ProductDAO;
import mn.turuu.springtest.dao.UserDAO;
import mn.turuu.springtest.form.SearchForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author PDBD
 */
@Controller
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private BaseController baseController;

    @RequestMapping
    public ModelAndView search(@ModelAttribute SearchForm searchForm) {
        ModelAndView mav = new ModelAndView("search-result");
        baseController.init(mav);
        mav.addObject("searchForm", searchForm);

        mav.addObject("products", productDAO.search(searchForm.getSearchText()));
        mav.addObject("users", userDAO.search(searchForm.getSearchText()));

        return mav;
    }
}
