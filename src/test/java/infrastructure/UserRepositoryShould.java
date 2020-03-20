package infrastructure;

import domain.Ad.Ad;
import domain.Ad.AdDescription;
import domain.Ad.AdTitle;
import domain.user.User;
import domain.user.UserId;
import org.junit.Assert;
import org.junit.Test;
import services.AdDatePostedFormat;

public class UserRepositoryShould {
    @Test
    public void save_and_retrieve_user_to_repository(){
        UserId userId = new UserId(1);
        User user = new User(userId);
        UserRepository userRepository = new UserRepository();

        userRepository.save(user);

        Assert.assertEquals(1, userRepository.getUsers().size());
    }
    @Test

    public void remove_favourite_ad_to_users_list(){
        UserId userId = new UserId(1);
        User user = new User(userId);
        UserRepository userRepository = new UserRepository();
        AdTitle adTitle = new AdTitle("Primer anuncio");
        AdDescription adDescription = new AdDescription("El primer anuncio del mundo");
        Ad ad = new Ad(adTitle, adDescription, new AdDatePostedFormat("17/03/2020"));
        AdTitle newAdTitle = new AdTitle("Segundo anuncio");
        AdDescription newAdDescription = new AdDescription("El segudno anuncio del mundo");
        Ad newAd = new Ad(newAdTitle, newAdDescription, new AdDatePostedFormat("17/03/2020"));
        user.favoriteAds(ad);
        user.favoriteAds(newAd);
        userRepository.save(user);

        userRepository.removeFavourite(ad);

        Assert.assertEquals(1, user.getFavoriteAds().size());
    }
}
