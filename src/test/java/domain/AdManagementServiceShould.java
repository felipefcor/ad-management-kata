package domain;

import domain.Ad.Ad;
import domain.Ad.DTO.AdDTO;
import domain.Ad.AdDescription;
import domain.Ad.AdTitle;
import domain.exceptions.AdDoesNotExistException;
import domain.exceptions.RepeteadAdException;
import domain.user.User;
import domain.user.UserId;
import infrastructure.AdRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import services.AdDatePostedFormat;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AdManagementServiceShould {
    @Mock
    AdDatePostedFormat adDatePostedFormat;
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
        Ad ad = new Ad(adTitle, adDescription, adDatePostedFormat);

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
        Ad ad = new Ad(adTitle, adDescription, new AdDatePostedFormat("19/03/2020"));
        Ad newAd = new Ad(newAdTitle, newAdDescription, new AdDatePostedFormat("19/03/2020"));
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
        Ad ad = new Ad(adTitle, adDescription, new AdDatePostedFormat("19/03/2020"));
        AdDTO adDTO = ad.createDTO();
        when(adRepositoryInMemory.getAd(adTitle)).thenReturn(adDTO);

        adManagementService.remove(adTitle);

        verify(adRepositoryInMemory).remove(adTitle);
    }

    @Test
    public void trhow_an_error_when_removes_an_ad_and_does_not_exist_in_the_catalog(){

        AdTitle adTitle = new AdTitle("Primer anuncio");

        when(adRepositoryInMemory.getAd(adTitle)).thenReturn(null);

        Assertions.assertThrows(AdDoesNotExistException.class, () -> adManagementService.remove(adTitle));

    }

    @Test
    public void send_the_command_purge_to_catalog_with_formatted_date(){

        AdTitle adTitle = new AdTitle("Primer anuncio");
        AdDescription adDescription = new AdDescription("El primer anuncio del mundo");
        Ad ad = new Ad(adTitle, adDescription, new AdDatePostedFormat("18/03/2020"));

        AdDTO adDTO = ad.createDTO();
        when(adRepositoryInMemory.getAd(adTitle)).thenReturn(adDTO);

        adManagementService.purge(new AdDatePostedFormat("19/03/2020"));

        verify(adRepositoryInMemory).purge(new AdDatePostedFormat("19/03/2020"));
    }


}
