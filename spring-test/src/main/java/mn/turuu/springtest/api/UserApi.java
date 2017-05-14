package mn.turuu.springtest.api;

import java.util.List;
import mn.turuu.springtest.dao.UserDAO;
import mn.turuu.springtest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PDBD
 */
@RequestMapping("/api/user")
@RestController
public class UserApi {

    @Autowired
    private UserDAO userDAO;

    @RequestMapping("{id}")
    @ResponseBody
    public User getUser(@PathVariable Integer id) {
        return userDAO.get(id);
    }

    @RequestMapping("list")
    @ResponseBody
    public List<User> getUserList() {
        return userDAO.list(true);
    }
}
