package infrastructure;

import domain.Ad.Ad;
import domain.Ad.AdDescription;
import domain.Ad.AdTitle;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import services.AdDatePostedFormat;

public class AdRepositoryInMemoryShould {

    @Test
    public void save_and_retrieve_an_ad_from_catalog(){

        AdTitle adTitle = new AdTitle("Primer anuncio");
        AdDescription adDescription = new AdDescription("El primer anuncio del mundo");
        Ad ad = new Ad(adTitle, adDescription, new AdDatePostedFormat("19/03/2020"));
        AdRepositoryInMemory adRepositoryInMemory = new AdRepositoryInMemory();

        adRepositoryInMemory.save(ad);

        Assert.assertEquals(ad.createDTO(), adRepositoryInMemory.getAd(adTitle));
    }

    @Test
    public void remove_an_ads_from_the_catalog(){

        AdTitle adTitle = new AdTitle("Primer anuncio");
        AdDescription adDescription = new AdDescription("El primer anuncio del mundo");
        Ad ad = new Ad(adTitle, adDescription, new AdDatePostedFormat("17/03/2020"));
        AdTitle newAdTitle = new AdTitle("Segundo anuncio");
        AdDescription newAdDescription = new AdDescription("El segundo anuncio del mundo");
        Ad newAd = new Ad(newAdTitle, newAdDescription, new AdDatePostedFormat("19/03/2020"));
        AdRepositoryInMemory adRepositoryInMemory = new AdRepositoryInMemory();
        adRepositoryInMemory.save(ad);
        adRepositoryInMemory.save(newAd);

        adRepositoryInMemory.remove(adTitle);

        Assert.assertEquals(1, adRepositoryInMemory.getAdList().size());
    }

    @Test
    public void get_the_list_of_ads_in_the_catalog(){

        AdTitle adTitle = new AdTitle("Primer anuncio");
        AdDescription adDescription = new AdDescription("El primer anuncio del mundo");
        Ad ad = new Ad(adTitle, adDescription, new AdDatePostedFormat("17/03/2020"));
        AdTitle newAdTitle = new AdTitle("Segundo anuncio");
        AdDescription newAdDescription = new AdDescription("El segundo anuncio del mundo");
        Ad newAd = new Ad(newAdTitle, newAdDescription, new AdDatePostedFormat("19/03/2020"));
        AdRepositoryInMemory adRepositoryInMemory = new AdRepositoryInMemory();
        adRepositoryInMemory.save(ad);
        adRepositoryInMemory.save(newAd);

        Assert.assertEquals(2, adRepositoryInMemory.getAdList().size());
    }

    @Test
    public void purge_an_ad_from_catalog(){

        AdTitle adTitle = new AdTitle("Primer anuncio");
        AdDescription adDescription = new AdDescription("El primer anuncio del mundo");
        Ad ad = new Ad(adTitle, adDescription, new AdDatePostedFormat("17/03/2020"));
        AdTitle newAdTitle = new AdTitle("Segundo anuncio");
        AdDescription newAdDescription = new AdDescription("El segundo anuncio del mundo");
        Ad newAd = new Ad(newAdTitle, newAdDescription, new AdDatePostedFormat("19/03/2020"));
        AdTitle thirdAdTitle = new AdTitle("Tercer anuncio");
        AdDescription thirdAdDescription = new AdDescription("El tercer anuncio del mundo");
        Ad thirdAd = new Ad(thirdAdTitle, thirdAdDescription, new AdDatePostedFormat("14/03/2020"));

        AdRepositoryInMemory adRepositoryInMemory = new AdRepositoryInMemory();
        adRepositoryInMemory.save(ad);
        adRepositoryInMemory.save(newAd);
        adRepositoryInMemory.save(thirdAd);

        adRepositoryInMemory.purge(new AdDatePostedFormat("19/03/2020"));

        Assert.assertEquals(1, adRepositoryInMemory.getAdList().size());
    }

    @Test
    public void remove_the_oldest_ad_when_the_catalog_reaches_100_ads(){
        AdRepositoryInMemory adRepositoryInMemory = new AdRepositoryInMemoryExpireByOldestAd();
        for (int i = 1; i < 7 ; i++) {
            for (int j = 10; j <30 ; j++) {
                AdTitle adTitle = new AdTitle("Primer anuncio" + i);
                AdDescription adDescription = new AdDescription("El primer anuncio del mundo" + i );
                Ad ad = new Ad(adTitle, adDescription, new AdDatePostedFormat(Integer.toString(j) + "/0"+ Integer.toString(i) + "/2020"));
                adRepositoryInMemory.save(ad);
            }
       }

        Assert.assertEquals(100, adRepositoryInMemory.getAdList().size());
    }
}
