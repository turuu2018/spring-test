package mn.turuu.springtest.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import mn.turuu.springtest.form.ImageUploadForm;
import mn.turuu.springtest.util.FileContentTypeUtil;
import mn.turuu.springtest.util.FileUtil;
import mn.turuu.springtest.util.ImageUtil;
import org.gm4java.engine.GMException;
import org.gm4java.engine.GMServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author PDBD
 */
@Controller
public class ImageUploadController {

    private static final Logger LOGGER = Logger.getLogger(ImageUploadController.class.getName());

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

    @Autowired
    private ImageUtil imageUtil;

    @RequestMapping(value = "/image-upload", method = RequestMethod.GET)
    public ModelAndView imageUpload() {
        ModelAndView mav = new ModelAndView("image-upload");
        mav.addObject("imageUploadForm", new ImageUploadForm());
        return mav;
    }

    @RequestMapping(value = "/image-upload", method = RequestMethod.POST)
    public void handleImageUpload(@ModelAttribute ImageUploadForm imageUploadForm) throws IOException {
        LOGGER.log(Level.INFO, "Checking images: {0}", imageUploadForm.getImages());
        if (imageUploadForm.getImages() != null) {
            for (MultipartFile multipartFile : imageUploadForm.getImages()) {
                LOGGER.log(Level.INFO, "Checking file: {0}", multipartFile);
                if (!multipartFile.isEmpty() && FileContentTypeUtil.isImage(multipartFile.getContentType())) {
                    String folderPath = System.getProperty("user.home") + "/images/" + dateFormat.format(new Date());
                    LOGGER.log(Level.INFO, "Creating dir: {0}", folderPath);
                    FileUtil.createDirectory(folderPath);

                    String extension = FileContentTypeUtil.getExtension(multipartFile.getContentType(), false);
                    String tempPath = folderPath + "/" + multipartFile.getOriginalFilename() + "_temp." + extension;
                    String targetPath = folderPath + "/" + multipartFile.getOriginalFilename() + "." + extension;
                    multipartFile.transferTo(new File(tempPath));

                    // create thumbnail
                    String thumbPath = folderPath + "/" + multipartFile.getOriginalFilename() + "_thumb." + extension;
                    //ImageUtil.createImage(sourcePath, thumbPath, 320, 240, extension);

                    try {
                        imageUtil.resize(tempPath, targetPath, 1280, 720, true, 75);
                        imageUtil.resize(tempPath, thumbPath, 320, 240, true, 75);

                        FileUtil.deleteFile(tempPath);
                    } catch (IOException | GMException | GMServiceException e) {
                        LOGGER.log(Level.SEVERE, null, e);
                    }
                }
            }
        }
    }
}
