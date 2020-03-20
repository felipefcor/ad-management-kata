package infrastructure;


import domain.user.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    public List<User> userList = new ArrayList<>();

    public void save(User user) {
        userList.add(user);
    }

    public List<User> getUsers() {
        return this.userList;
    }

}
