package mn.turuu.springtest.model;

import java.util.Date;

/**
 *
 * @author PDBD
 */
public class UserData {

    private String fullName;
    private Date registeredDate;

    public UserData(String fullName, Date registeredDate) {
        this.fullName = fullName;
        this.registeredDate = registeredDate;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }
}
