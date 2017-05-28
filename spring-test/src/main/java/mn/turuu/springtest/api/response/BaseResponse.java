package mn.turuu.springtest.api.response;

import java.io.Serializable;

/**
 *
 * @author PDBD
 */
public class BaseResponse implements Serializable {

    private Object data;
    private boolean result;
    private String messaage;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getMessaage() {
        return messaage;
    }

    public void setMessaage(String messaage) {
        this.messaage = messaage;
    }
}
