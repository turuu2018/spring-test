package mn.turuu.springtest.model;
// Generated May 28, 2017 1:45:33 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name="user"
    ,catalog="springtest"
)
public class User  implements java.io.Serializable {


     private Integer id;
     private String username;
     private String password;
     private String lastName;
     private String firstName;
     private Date registeredDate;
     private Date lastLoggedDate;
     private boolean active;
     private String activateToken;
     private Date activatedDate;
     private Set<UserRole> userRoles = new HashSet<UserRole>(0);
     private Set<Basket> baskets = new HashSet<Basket>(0);

    public User() {
    }

	
    public User(String username, String password, Date registeredDate, boolean active) {
        this.username = username;
        this.password = password;
        this.registeredDate = registeredDate;
        this.active = active;
    }
    public User(String username, String password, String lastName, String firstName, Date registeredDate, Date lastLoggedDate, boolean active, String activateToken, Date activatedDate, Set<UserRole> userRoles, Set<Basket> baskets) {
       this.username = username;
       this.password = password;
       this.lastName = lastName;
       this.firstName = firstName;
       this.registeredDate = registeredDate;
       this.lastLoggedDate = lastLoggedDate;
       this.active = active;
       this.activateToken = activateToken;
       this.activatedDate = activatedDate;
       this.userRoles = userRoles;
       this.baskets = baskets;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="username", nullable=false, length=50)
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    
    @Column(name="password", nullable=false, length=64)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    
    @Column(name="last_name")
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
    @Column(name="first_name")
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="registered_date", nullable=false, length=19)
    public Date getRegisteredDate() {
        return this.registeredDate;
    }
    
    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="last_logged_date", length=19)
    public Date getLastLoggedDate() {
        return this.lastLoggedDate;
    }
    
    public void setLastLoggedDate(Date lastLoggedDate) {
        this.lastLoggedDate = lastLoggedDate;
    }

    
    @Column(name="active", nullable=false)
    public boolean isActive() {
        return this.active;
    }
    
    public void setActive(boolean active) {
        this.active = active;
    }

    
    @Column(name="activate_token", length=50)
    public String getActivateToken() {
        return this.activateToken;
    }
    
    public void setActivateToken(String activateToken) {
        this.activateToken = activateToken;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="activated_date", length=19)
    public Date getActivatedDate() {
        return this.activatedDate;
    }
    
    public void setActivatedDate(Date activatedDate) {
        this.activatedDate = activatedDate;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="user")
    public Set<UserRole> getUserRoles() {
        return this.userRoles;
    }
    
    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="user")
    public Set<Basket> getBaskets() {
        return this.baskets;
    }
    
    public void setBaskets(Set<Basket> baskets) {
        this.baskets = baskets;
    }




}


