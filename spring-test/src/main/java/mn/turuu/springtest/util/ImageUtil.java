package mn.turuu.springtest.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;
import org.gm4java.engine.GMException;
import org.gm4java.engine.GMService;
import org.gm4java.engine.GMServiceException;
import org.gm4java.engine.support.GMConnectionPoolConfig;
import org.gm4java.engine.support.PooledGMService;
import org.imgscalr.Scalr;
import org.springframework.stereotype.Component;

/**
 *
 * @author PDBD
 */
@Component
public class ImageUtil {

    private GMService gmService;

    @PostConstruct
    public void init() {
        GMConnectionPoolConfig config = new GMConnectionPoolConfig();
        gmService = new PooledGMService(config);
    }

    public String optimize(String input, String output, int quality) throws IOException, GMException, GMServiceException {
        return gmService.execute("convert",
                input,
                "-auto-orient",
                "-quality",
                "" + quality,
                "-compress",
                "LZMA",
                output);
    }

    public String resize(String input, String output, int width, int height, boolean optimize, int quality) throws IOException, GMException, GMServiceException {
        if (optimize) {
            return gmService.execute("convert",
                    "-size",
                    width + "x" + height,
                    input,
                    "-auto-orient",
                    "-resize",
                    width + "x" + height,
                    "-quality",
                    "" + quality,
                    "-compress",
                    "LZMA",
                    output);
        } else {
            return gmService.execute("convert",
                    "-size",
                    width + "x" + height,
                    input,
                    "-auto-orient",
                    "-resize",
                    width + "x" + height,
                    "-compress",
                    "LZMA",
                    output);
        }
    }

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
