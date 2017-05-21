package mn.turuu.springtest.service;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import mn.turuu.springtest.dao.EmailQueueDAO;
import mn.turuu.springtest.model.EmailQueue;
import mn.turuu.springtest.util.EmailTemplateUtil;
import mn.turuu.springtest.util.UrlUtils;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 * @author PDBD
 */
@Service
public class EmailSender {

    private static final Logger LOGGER = Logger.getLogger(EmailSender.class.getName());

    @Value("${smtp.host}")
    private String smtpHost;

    @Value("${smtp.port}")
    private int smtpPort;

    @Value("${smtp.username}")
    private String smtpUsername;

    @Value("${smtp.password}")
    private String smtpPassword;

    @Autowired
    private EmailTemplateUtil emailTemplateUtil;

    @Autowired
    private EmailQueueDAO emailQueueDAO;

    private HtmlEmail constructEmail(String to, String subject, String body) throws EmailException {
        HtmlEmail email = new HtmlEmail();

        //email.setSSLOnConnect(true);
        email.setStartTLSEnabled(true);
        //email.setSSLCheckServerIdentity(false);

        email.setHostName(smtpHost);
        email.setSmtpPort(smtpPort);
        email.setAuthentication(smtpUsername, smtpPassword);
        email.setFrom(smtpUsername);

        email.setSubject(subject);
        email.addTo(to);
        email.setCharset(org.apache.commons.mail.EmailConstants.UTF_8);

        email.setHtmlMsg(body);
        email.setTextMsg(body);

        return email;
    }

    public void sendEmail(String to, String subject, String body) throws EmailException {
        HtmlEmail email = constructEmail(to, subject, body);
        email.send();
    }

    public void sendActivateEmail(HttpServletRequest request, String email, String token) {
        LOGGER.log(Level.INFO, "Sending email to: {0}", email);
        // add to queue when error occured
        // use cronjob to process email queue
        String emailTitle = "Welcome to Spring test";
        String emailBody = emailTemplateUtil.getActivationEmail(UrlUtils.getActivateUrl(request), token);
        try {
            sendEmail(email, emailTitle, emailBody);
        } catch (EmailException e) {
            LOGGER.log(Level.INFO, "Sending email failed : {0}", e.getMessage());
            LOGGER.log(Level.SEVERE, null, e);

            EmailQueue emailQueue = new EmailQueue(smtpUsername, email, emailTitle, emailBody, new Date());
            emailQueueDAO.save(emailQueue);
        }
    }
}
