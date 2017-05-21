package mn.turuu.springtest.form;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author PDBD
 */
public class ImageUploadForm {

    private List<MultipartFile> images;

    public List<MultipartFile> getImages() {
        return images;
    }

    public void setImages(List<MultipartFile> images) {
        this.images = images;
    }
}
