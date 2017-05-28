package mn.turuu.springtest.model;
// Generated May 28, 2017 1:21:27 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * UserRoleId generated by hbm2java
 */
@Embeddable
public class UserRoleId  implements java.io.Serializable {


     private int userId;
     private String role;

    public UserRoleId() {
    }

    public UserRoleId(int userId, String role) {
       this.userId = userId;
       this.role = role;
    }
   


    @Column(name="user_id", nullable=false)
    public int getUserId() {
        return this.userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }


    @Column(name="role", nullable=false, length=50)
    public String getRole() {
        return this.role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof UserRoleId) ) return false;
		 UserRoleId castOther = ( UserRoleId ) other; 
         
		 return (this.getUserId()==castOther.getUserId())
 && ( (this.getRole()==castOther.getRole()) || ( this.getRole()!=null && castOther.getRole()!=null && this.getRole().equals(castOther.getRole()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getUserId();
         result = 37 * result + ( getRole() == null ? 0 : this.getRole().hashCode() );
         return result;
   }   


}


