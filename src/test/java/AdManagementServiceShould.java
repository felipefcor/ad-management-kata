import domain.Ad.Ad;
import domain.Ad.AdDescription;
import domain.AdManagementService;
import domain.Ad.AdTitle;
import infrastructure.AdRepository;
import org.junit.Test;
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

    @Test
        public void send_new_ad_to_repo(){

        MockitoAnnotations.initMocks(this);
        AdTitle adTitle = new AdTitle("Primer anuncio");
        AdDescription adDescription = new AdDescription("El primer anuncio del mundo");
        AdManagementService adManagementService = new AdManagementService(adRepositoryInMemory, adDatePosted);
        when(adDatePosted.getDate()).thenReturn("19/03/2020");
        Ad ad = new Ad(adTitle, adDescription, adDatePosted.getDate());
        adManagementService.add(ad);
        verify(adRepositoryInMemory).save(ad);

    }

}
