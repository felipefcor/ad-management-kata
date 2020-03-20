package domain.user;

import domain.Ad.DTO.AdDTO;
import domain.user.DTO.UserDTO;

import java.util.Objects;

public class User {
    private UserId userId;

    public User(UserId userId) {

        this.userId = userId;
    }
    public UserDTO createUserDTO() {
        UserDTO userDTO = new UserDTO();
        userDTO.userId = this.userId;
        return userDTO;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }

}
