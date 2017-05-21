package mn.turuu.springtest.util;

import java.io.File;

/**
 *
 * @author PDBD
 */
public class FileUtil {

    public static boolean createDirectory(String path) {
        boolean result = false;

        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
            result = true;
        } else if (file.isDirectory()) {
            result = false;
        }

        return result;
    }

    public static boolean deleteFile(String path) {
        File file = new File(path);
        if (file.exists() && file.canRead()) {
            return file.delete();
        }
        return false;
    }
}
