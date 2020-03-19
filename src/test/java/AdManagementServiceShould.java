import domain.Ad.Ad;
import domain.Ad.AdDTO;
import domain.Ad.AdDescription;
import domain.AdManagementService;
import domain.Ad.AdTitle;
import domain.exceptions.AdDoesNotExistException;
import domain.exceptions.RepeteadAdException;
import infrastructure.AdRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import services.AdDatePosted;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AdManagementServiceShould {
    @Mock
    AdDatePosted adDatePosted;
    @Mock
    AdRepository adRepositoryInMemory;
    @InjectMocks
    AdManagementService adManagementService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }
    @Test
        public void send_new_ad_to_catalog(){

        AdTitle adTitle = new AdTitle("Primer anuncio");
        AdDescription adDescription = new AdDescription("El primer anuncio del mundo");
        when(adDatePosted.getDate()).thenReturn("19/03/2020");
        Ad ad = new Ad(adTitle, adDescription, adDatePosted.getDate() );

        adManagementService.add(adTitle, adDescription);

        verify(adRepositoryInMemory).save(ad);

    }

    @Test
        public void trhow_an_error_when_the_adTitle_and_adDescription_already_exists_in_the_ad_catalog(){

        AdTitle adTitle = new AdTitle("Primer anuncio");
        AdDescription adDescription = new AdDescription("El primer anuncio del mundo");
        when(adRepositoryInMemory.matchAd(adTitle, adDescription)).thenReturn(true);

        Assertions.assertThrows(RepeteadAdException.class, () -> adManagementService.add(adTitle, adDescription));

    }

    @Test
        public void retrieve_the_ads_list_from_catalog(){

        AdTitle adTitle = new AdTitle("Primer anuncio");
        AdDescription adDescription = new AdDescription("El primer anuncio del mundo");
        AdTitle newAdTitle = new AdTitle("Segundo anuncio");
        AdDescription newAdDescription = new AdDescription("El segundo anuncio del mundo");
        when(adDatePosted.getDate()).thenReturn("19/03/2020");
        Ad ad = new Ad(adTitle, adDescription, adDatePosted.getDate());
        Ad newAd = new Ad(newAdTitle, newAdDescription, adDatePosted.getDate());
        List<Ad> ads = new ArrayList<>();
        ads.add(ad);
        ads.add(newAd);

        when(adRepositoryInMemory.getAdList()).thenReturn(ads);

        Assert.assertEquals(2, adManagementService.getAdList().size());

    }

    @Test
        public void remove_an_ad_from_catalog(){

        AdTitle adTitle = new AdTitle("Primer anuncio");
        AdDescription adDescription = new AdDescription("El primer anuncio del mundo");
        when(adDatePosted.getDate()).thenReturn("19/03/2020");
        Ad ad = new Ad(adTitle, adDescription, adDatePosted.getDate());

        adManagementService.remove(adTitle);

        verify(adRepositoryInMemory).remove(adTitle);
    }

    @Test
    public void trhow_an_error_when_removes_an_ad_and_not_exists_in_the_catalog(){

        AdTitle adTitle = new AdTitle("Primer anuncio");

        when(adRepositoryInMemory.getAd(adTitle)).thenReturn(null);

        Assertions.assertThrows(AdDoesNotExistException.class, () -> adManagementService.remove(adTitle));

    }

}
