package mn.turuu.springtest;

import java.util.logging.Logger;
import mn.turuu.springtest.config.RootConfig;
import mn.turuu.springtest.cron.EmailSenderCron;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 *
 * @author PDBD
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@WebAppConfiguration
@ActiveProfiles("development")
public class EmailSenderCronTest {

    private static final Logger LOGGER = Logger.getLogger(EmailSenderCron.class.getName());

    @Autowired
    private EmailSenderCron emailSenderCron;

    @Test
    public void testCron() {
        LOGGER.info("Testing email sender cron");
        emailSenderCron.processQueue();
    }
}
