package mn.turuu.springtest.api;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mn.turuu.springtest.api.response.BaseResponse;
import mn.turuu.springtest.dao.BasketDAO;
import mn.turuu.springtest.dao.ProductDAO;
import mn.turuu.springtest.dao.UserDAO;
import mn.turuu.springtest.model.Basket;
import mn.turuu.springtest.model.Product;
import mn.turuu.springtest.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PDBD
 */
@RestController
@RequestMapping("/api/basket")
public class BasketApi {

    private static final Logger LOGGER = Logger.getLogger(BasketApi.class.getName());

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private BasketDAO basketDAO;

    @Autowired
    private ProductDAO productDAO;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @ResponseBody
    public List<Basket> getBasket(Principal principal) {
        User user = userDAO.get(principal.getName());

        LOGGER.log(Level.INFO, "Getting basket for user: {0}", user);
        return basketDAO.list(user);
    }

    @RequestMapping(value = "add-product", method = RequestMethod.GET)
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @ResponseBody
    public BaseResponse addProduct(int productId, int quantity, Principal principal) {
        BaseResponse baseResponse = new BaseResponse();

        LOGGER.log(Level.INFO, "Adding {0}:{1} to basket: {2}", new Object[]{productId, quantity, principal.getName()});

        Session session = null;
        try {
            session = sessionFactory.openSession();

            User user = userDAO.get(principal.getName());
            Product product = productDAO.get(productId);

            Basket basket = basketDAO.get(user, product);
            if (basket == null) {
                basket = new Basket(user, product, quantity, new Date());
            } else {
                basket.setQuantity(basket.getQuantity() + quantity);
            }
            session.saveOrUpdate(basket);
            session.flush();

            baseResponse.setResult(true);
            baseResponse.setData(basket);
        } catch (HibernateException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
            baseResponse.setMessaage(e.getMessage());
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (HibernateException e) {
                }
            }
        }

        return baseResponse;
    }
}
