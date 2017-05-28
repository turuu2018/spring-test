package mn.turuu.springtest.dao;

import java.util.List;
import java.util.logging.Logger;
import mn.turuu.springtest.model.Product;
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
public class ProductDAO {

    private static final Logger LOGGER = Logger.getLogger(BasketDAO.class.getName());

    @Autowired
    private SessionFactory sessionFactory;

    public Product get(int id) {
        Session session = sessionFactory.getCurrentSession();

        Criteria crit = session.createCriteria(Product.class);
        crit.add(Restrictions.eq("id", id));
        List<Product> list = crit.list();
        if (list.size() == 1) {
            return list.get(0);
        }

        return null;
    }

    public List<Product> list() {
        Session session = sessionFactory.getCurrentSession();

        Criteria crit = session.createCriteria(Product.class);
        return crit.list();
    }
}
