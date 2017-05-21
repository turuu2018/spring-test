package mn.turuu.springtest.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.imgscalr.Scalr;

/**
 *
 * @author PDBD
 */
public class ImageUtil {

    public static boolean createImage(String sourcePath, String targetPath, int width, int height, String format) throws IOException {
        BufferedImage sourceImage = ImageIO.read(new File(sourcePath));
        BufferedImage targetImage;
        if (sourceImage.getWidth() > sourceImage.getHeight()) {
            targetImage = Scalr.resize(sourceImage, Scalr.Method.SPEED, Scalr.Mode.FIT_TO_WIDTH, width);
        } else {
            targetImage = Scalr.resize(sourceImage, Scalr.Method.SPEED, Scalr.Mode.FIT_TO_HEIGHT, height);
        }

        return ImageIO.write(targetImage, format, new File(targetPath));
    }
}
