package mn.turuu.springtest.util;

import java.io.File;
import java.io.IOException;
import org.gm4java.engine.GMException;
import org.gm4java.engine.GMServiceException;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author PDBD
 */
public class ImageUtilTest {

    private ImageUtil imageUtil;
    private String targetPath;
    private String inputPath = "input.jpg";
    private String optimizeOutput = "optimize.jpg";
    private String resizeOutput = "resize.jpg";

    @Before
    public void setup() {
        imageUtil = new ImageUtil();
        imageUtil.init();

        inputPath = new File(ImageUtilTest.class.getResource("/images/" + inputPath).getFile()).getAbsolutePath();
        targetPath = new File("target").getAbsolutePath();
    }

    @Test
    public void testOptimize() throws IOException, GMException, GMServiceException {
        imageUtil.optimize(inputPath, targetPath + "/" + optimizeOutput, 75);
    }

    @Test
    public void testResize() throws IOException, GMException, GMServiceException {
        imageUtil.resize(inputPath, targetPath + "/" + resizeOutput, 1280, 720, true, 75);
    }
}
