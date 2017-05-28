package mn.turuu.springtest.dao;

import java.util.List;
import java.util.logging.Logger;
import mn.turuu.springtest.model.Basket;
import mn.turuu.springtest.model.Product;
import mn.turuu.springtest.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PDBD
 */
@Repository
public class BasketDAO {

    private static final Logger LOGGER = Logger.getLogger(BasketDAO.class.getName());

    @Autowired
    private SessionFactory sessionFactory;

    public Basket get(User user, Product product) {
        Session session = sessionFactory.getCurrentSession();

        Criteria crit = session.createCriteria(Basket.class);
        crit.add(Restrictions.eq("user", user));
        crit.add(Restrictions.eq("product", product));

        List<Basket> list = crit.list();
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    public List<Basket> list(User user) {
        Session session = sessionFactory.getCurrentSession();

        Criteria crit = session.createCriteria(Basket.class);
        crit.add(Restrictions.eq("user", user));
        return crit.list();
    }
}
