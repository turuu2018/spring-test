package mn.turuu.springtest.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author PDBD
 */
@Entity
@Table(name = "user_role")
public class UserRole implements java.io.Serializable {

    @EmbeddedId
    @AttributeOverrides({
        @AttributeOverride(name = "userId", column = @Column(name = "user_id", nullable = false)),
        @AttributeOverride(name = "role", column = @Column(name = "role", length = 50, nullable = false))
    })
    private UserRoleId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false)
    private User user;

    public UserRole() {
    }

    public UserRole(UserRoleId id, User user) {
        this.id = id;
        this.user = user;
    }

    public UserRoleId getId() {
        return id;
    }

    public void setId(UserRoleId id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
