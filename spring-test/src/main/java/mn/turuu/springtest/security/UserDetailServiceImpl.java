package mn.turuu.springtest.security;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mn.turuu.springtest.dao.UserDAO;
import mn.turuu.springtest.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author PDBD
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private static final Logger LOGGER = Logger.getLogger(UserDetailServiceImpl.class.getName());

    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        mn.turuu.springtest.model.User user = userDAO.get(username);
        if (user != null) {
            //LOGGER.log(Level.INFO, "Testing password: {0}", user.getPassword());
            return new User(user.getUsername(), user.getPassword(), user.isActive(), true, true, true, buildUserAuthority(user.getUserRoles()));
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }

    private List<GrantedAuthority> buildUserAuthority(List<UserRole> userRoles) {
        List<GrantedAuthority> authList = new ArrayList<>();
        for (UserRole userRole : userRoles) {
            authList.add(new SimpleGrantedAuthority(userRole.getId().getRole()));
        }
        return authList;
    }
}
