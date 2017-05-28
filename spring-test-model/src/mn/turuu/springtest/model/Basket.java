package mn.turuu.springtest.model;
// Generated May 28, 2017 1:45:33 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Basket generated by hbm2java
 */
@Entity
@Table(name="basket"
    ,catalog="springtest"
    , uniqueConstraints = @UniqueConstraint(columnNames={"user_id", "product_id"}) 
)
public class Basket  implements java.io.Serializable {


     private Integer id;
     private Product product;
     private User user;
     private int quantity;
     private Date addedDate;

    public Basket() {
    }

    public Basket(Product product, User user, int quantity, Date addedDate) {
       this.product = product;
       this.user = user;
       this.quantity = quantity;
       this.addedDate = addedDate;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="product_id", nullable=false)
    public Product getProduct() {
        return this.product;
    }
    
    public void setProduct(Product product) {
        this.product = product;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id", nullable=false)
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }

    
    @Column(name="quantity", nullable=false)
    public int getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="added_date", nullable=false, length=19)
    public Date getAddedDate() {
        return this.addedDate;
    }
    
    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }




}


