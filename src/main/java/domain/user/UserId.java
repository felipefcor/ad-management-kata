package domain.user;

import domain.user.DTO.UserDTO;
import domain.user.DTO.UserIdDTO;

import java.util.Objects;

public class UserId {
    private int userId;

    public UserId(int userId) {
        this.userId = userId;
    }

    public UserIdDTO createUserIdDTO() {
        UserIdDTO userIdDTO = new UserIdDTO();
        userIdDTO.userId = this.userId;
        return userIdDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserId userId1 = (UserId) o;
        return userId == userId1.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }
}
