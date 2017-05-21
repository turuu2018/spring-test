package mn.turuu.springtest.util;

/**
 *
 * @author PDBD
 */
public class FileContentTypeUtil {

    public static boolean isImage(String contentType) {
        return contentType != null &&
                (contentType.equals("image/jpeg")
                || contentType.equals("image/png")
                || contentType.equals("image/gif"));
    }

    public static String getExtension(String contentType, boolean withDot) {
        String extension = "";

        switch(contentType) {
            case "image/jpeg":
                extension = "jpg";
                break;
            case "image/png":
                extension = "png";
                break;
            case "image/gif":
                extension = "gif";
                break;
        }
        if (withDot) {
            extension = "." + extension;
        }

        return extension;
    }
}
