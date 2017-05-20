package mn.turuu.springtest.util;

import java.util.HashMap;
import java.util.Map;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineUtils;

/**
 *
 * @author PDBD
 */
@Component
public class EmailTemplateUtil {

    @Autowired
    private VelocityEngine velocityEngine;

    public String getActivationEmail(String activationUrl, String activationToken) {
        Map<String, Object> model = new HashMap<>();
        model.put("activationUrl", activationUrl);
        model.put("activationToken", activationToken);

        return VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "templates/activation.vm", "UTF-8", model);
    }
}
