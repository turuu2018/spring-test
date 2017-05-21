package mn.turuu.springtest.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mn.turuu.springtest.model.EmailQueue;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
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
public class EmailQueueDAO {

    private static final Logger LOGGER = Logger.getLogger(EmailQueueDAO.class.getName());

    @Autowired
    private SessionFactory sessionFactory;

    public void save(EmailQueue emailQueue) {
        Session session  = null;
        try {
            session = sessionFactory.openSession();
            session.saveOrUpdate(emailQueue);
            session.flush();
        } catch (HibernateException e) {
            LOGGER.log(Level.SEVERE, null, e);
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (HibernateException e) {
                }
            }
        }
    }

    public List<EmailQueue> list(Session session, Boolean hasSent) throws HibernateException {
        if (session == null) {
            session = sessionFactory.getCurrentSession();
        }
        Criteria crit = session.createCriteria(EmailQueue.class);
        if (hasSent != null) {
            if (hasSent) {
                crit.add(Restrictions.isNotNull("sentDate"));
            } else {
                crit.add(Restrictions.isNull("sentDate"));
            }
        }
        return crit.list();
    }
}
