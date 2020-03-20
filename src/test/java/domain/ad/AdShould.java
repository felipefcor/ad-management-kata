package domain.ad;

import domain.Ad.Ad;
import domain.Ad.AdDescription;
import domain.Ad.AdTitle;
import domain.exceptions.TitleAndDescriptionAreTheSameException;
import domain.user.User;
import domain.user.UserId;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import services.AdDatePostedFormat;


public class AdShould {


    @Test
    public void throw_an_error_when_title_and_description_of_an_ad_are_the_same(){
        AdTitle adTitle = new AdTitle("Esto es una prueba");
        AdDescription adDescription = new AdDescription("Esto es una prueba");

        Assertions.assertThrows(TitleAndDescriptionAreTheSameException.class, () -> new Ad(adTitle, adDescription, new AdDatePostedFormat("18/03/2020")));
    }

    @Test
    public void keep_the_times_an_ad_is_marked_as_a_favourite_by_users(){
        AdTitle adTitle = new AdTitle("Esto es una prueba");
        AdDescription adDescription = new AdDescription("Esto es una prueba de todo");
        Ad ad = new Ad(adTitle, adDescription, new AdDatePostedFormat("18/03/2020"));
        UserId userId = new UserId(1);
        UserId newUserId = new UserId(2);
        User user = new User(userId);
        User newUser = new User(newUserId);

        ad.markedAsAFavouriteByAUser(user);
        ad.markedAsAFavouriteByAUser(newUser);

        Assert.assertEquals(2, ad.getNumberOfUserMarkedAsAFavourite().size());
    }

}
