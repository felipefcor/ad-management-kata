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
    public void mark_an_ad_as_a_favourite_vy_user(){
        UserId userId = new UserId(1);
        User user = new User(userId);
        AdTitle adTitle = new AdTitle("Primer anuncio");
        AdDescription adDescription = new AdDescription("El primer anuncio del mundo");
        Ad ad = new Ad(adTitle, adDescription, new AdDatePostedFormat("17/03/2020"));
        user.favoriteAds(ad);

        Assert.assertEquals(1, user.getFavoriteAds().size());
    }
}
