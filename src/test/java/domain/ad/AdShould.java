package domain.ad;

import domain.Ad.Ad;
import domain.Ad.AdDescription;
import domain.Ad.AdTitle;
import domain.exceptions.TitleAndDescriptionAreTheSameException;
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

}
