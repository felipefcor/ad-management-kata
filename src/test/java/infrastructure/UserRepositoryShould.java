package infrastructure;

import domain.user.User;
import domain.user.UserId;
import org.junit.Assert;
import org.junit.Test;

public class UserRepositoryShould {
    @Test
    public void save_and_retrieve_user_to_repository(){
        UserId userId = new UserId(1);
        User user = new User(userId);
        UserRepository userRepository = new UserRepository();

        userRepository.save(user);

        Assert.assertEquals(1, userRepository.getUsers().size());
    }
}
