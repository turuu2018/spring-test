package mn.turuu.springtest.controller.product;

import mn.turuu.springtest.dao.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author PDBD
 */
@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductDAO productDAO;

    @RequestMapping
    public ModelAndView products() {
        ModelAndView mav = new ModelAndView("products");
        mav.addObject("products", productDAO.list());
        return mav;
    }
}
