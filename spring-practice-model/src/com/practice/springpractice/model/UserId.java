package com.practice.springpractice.model;
// Generated May 9, 2017 5:23:14 PM by Hibernate Tools 4.3.1



/**
 * UserId generated by hbm2java
 */
public class UserId  implements java.io.Serializable {


     private String host;
     private String user;

    public UserId() {
    }

    public UserId(String host, String user) {
       this.host = host;
       this.user = user;
    }
   
    public String getHost() {
        return this.host;
    }
    
    public void setHost(String host) {
        this.host = host;
    }
    public String getUser() {
        return this.user;
    }
    
    public void setUser(String user) {
        this.user = user;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof UserId) ) return false;
		 UserId castOther = ( UserId ) other; 
         
		 return ( (this.getHost()==castOther.getHost()) || ( this.getHost()!=null && castOther.getHost()!=null && this.getHost().equals(castOther.getHost()) ) )
 && ( (this.getUser()==castOther.getUser()) || ( this.getUser()!=null && castOther.getUser()!=null && this.getUser().equals(castOther.getUser()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getHost() == null ? 0 : this.getHost().hashCode() );
         result = 37 * result + ( getUser() == null ? 0 : this.getUser().hashCode() );
         return result;
   }   


}


