package mn.turuu.springtest.util;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author PDBD
 */
public class UrlUtils {

    public static String getURLWithContextPath(HttpServletRequest request) {
        String url = request.getScheme() + "://" + request.getServerName();
        if (request.getServerPort() != 80) {
            url += ":" + request.getServerPort();
        }
        url += request.getContextPath();
        return url;
    }

    public static String getActivateUrl(HttpServletRequest request) {
        return getURLWithContextPath(request) + "/activate";
    }
}
