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

    @Test
    public void mark_as_a_favourite_an_ad_and_save_it(){
        UserId userId = new UserId(1);
        User user = new User(userId);
        AdTitle adTitle = new AdTitle("Primer anuncio");
        AdDescription adDescription = new AdDescription("El primer anuncio del mundo");
        Ad ad = new Ad(adTitle, adDescription, new AdDatePostedFormat("17/03/2020"));
        UserRepository userRepository = new UserRepository();

        userRepository.favoriteAds(ad);

        Assert.assertEquals(1, userRepository.getFavoriteAds().size());
    }
}
