import domain.Ad.Ad;
import domain.Ad.AdDescription;
import domain.AdManagementService;
import domain.Ad.AdTitle;
import domain.exceptions.RepeteadAdException;
import infrastructure.AdRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import services.AdDatePosted;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AdManagementServiceShould {
    @Mock
    AdDatePosted adDatePosted;
    @Mock
    AdRepository adRepositoryInMemory;
    @InjectMocks
    AdManagementService adManagementService;

    @Test
        public void send_new_ad_to_repo(){

        MockitoAnnotations.initMocks(this);
        AdTitle adTitle = new AdTitle("Primer anuncio");
        AdDescription adDescription = new AdDescription("El primer anuncio del mundo");
        when(adDatePosted.getDate()).thenReturn("19/03/2020");
        Ad ad = new Ad(adTitle, adDescription, adDatePosted.getDate() );
        adManagementService.add(adTitle, adDescription);
        verify(adRepositoryInMemory).save(ad);

    }

    @Test
        public void trhow_an_error_when_the_adTitle_and_adDescription_already_exists_in_the_ad_catalog(){
        MockitoAnnotations.initMocks(this);

        AdTitle adTitle = new AdTitle("Primer anuncio");
        AdDescription adDescription = new AdDescription("El primer anuncio del mundo");
        when(adRepositoryInMemory.matchAd(adTitle, adDescription)).thenReturn(true);

        Assertions.assertThrows(RepeteadAdException.class, () -> adManagementService.add(adTitle, adDescription));

    }

}
