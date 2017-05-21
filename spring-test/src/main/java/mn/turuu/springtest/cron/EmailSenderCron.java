package mn.turuu.springtest.cron;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mn.turuu.springtest.dao.EmailQueueDAO;
import mn.turuu.springtest.model.EmailQueue;
import mn.turuu.springtest.service.EmailSender;
import org.apache.commons.mail.EmailException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *
 * @author PDBD
 */
@Component
public class EmailSenderCron {

    private static final Logger LOGGER = Logger.getLogger(EmailSenderCron.class.getName());

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private EmailQueueDAO emailQueueDAO;

    @Autowired
    private EmailSender emailSender;

    @Scheduled(initialDelay=5000, fixedRate=300000)
    public void processQueue() {
        LOGGER.info("Processing email queue");

        Session session = null;
        try {
            session = sessionFactory.openSession();

            List<EmailQueue> emails = emailQueueDAO.list(session, false);
            for (EmailQueue emailQueue : emails) {
                try {
                    emailSender.sendEmail(emailQueue.getToEmail(), emailQueue.getTitle(), emailQueue.getContent());

                    emailQueue.setSentDate(new Date());
                    session.saveOrUpdate(emailQueue);
                    session.flush();
                } catch (EmailException e) {
                }
            }
        } catch (HibernateException e) {
            LOGGER.info("Processing email queue failed");
            LOGGER.log(Level.SEVERE, null, e);
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (HibernateException e) {
                }
            }
        }

        LOGGER.info("Email queue process done.");
    }
}
