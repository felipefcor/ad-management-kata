package domain.user;

import domain.Ad.Ad;
import domain.Ad.AdDescription;
import domain.Ad.AdTitle;
import infrastructure.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import services.AdDatePostedFormat;

public class UserShould {
    @Test
    public void save_and_retrieve_user_from(){
        UserId userId = new UserId(1);
        User user = new User(userId);
        UserRepository userRepository = new UserRepository();

        userRepository.save(user);

        Assert.assertEquals(1, userRepository.getUsers().size());
    }
}
