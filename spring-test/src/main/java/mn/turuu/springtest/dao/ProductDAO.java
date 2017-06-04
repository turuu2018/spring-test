package mn.turuu.springtest.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mn.turuu.springtest.model.Product;
import org.apache.lucene.search.Query;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
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

    public List<Product> search(String searchText) {
        List results = null;

        try {
            Session session = sessionFactory.getCurrentSession();

            FullTextSession ftSession = Search.getFullTextSession(session);
            ftSession.createIndexer().startAndWait();

            QueryBuilder qb = ftSession.getSearchFactory().buildQueryBuilder().forEntity(Product.class).get();
            Query l_q = qb.keyword().onFields("name").matching(searchText).createQuery();
            org.hibernate.Query h_q = ftSession.createFullTextQuery(l_q, Product.class);
            results = h_q.list();
        } catch (HibernateException | InterruptedException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }

        return results;
    }
}
