package infrastructure;

import domain.user.DTO.UserDTO;
import domain.user.User;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    public List<User> userList = new ArrayList<>();

    public void save(User user) {
        this.userList.add(user);
    }

    public List<UserDTO> getUsers() {
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User user : this.userList) {
            UserDTO userDTO = user.createUserDTO();
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }


}
