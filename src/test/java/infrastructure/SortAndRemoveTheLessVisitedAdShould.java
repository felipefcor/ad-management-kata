package infrastructure;

import domain.Ad.Ad;
import domain.Ad.AdDescription;
import domain.Ad.AdTitle;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import services.AdDatePostedFormat;

import java.util.ArrayList;
import java.util.List;

public class SortAndRemoveTheLessVisitedAdShould {

    @Test
    public void sort_and_remove_the_less_visited_ad(){

        AdRepositoryInMemory adRepositoryInMemory = new AdRepositoryInMemoryExpireByLessVisitedAd();

        AdTitle adTitle = new AdTitle("Primer anuncio");
        AdDescription adDescription = new AdDescription("El primer anuncio del mundo");
        Ad ad = new Ad(adTitle, adDescription, new AdDatePostedFormat("17/03/2020"));
        ad.createDTO().adVisits.createAdAccessesDTO().queueVisits.add(15);
        AdTitle newAdTitle = new AdTitle("Segundo anuncio");
        AdDescription newAdDescription = new AdDescription("El segundo anuncio del mundo");
        Ad newAd = new Ad(newAdTitle, newAdDescription, new AdDatePostedFormat("19/03/2020"));
        newAd.createDTO().adVisits.createAdAccessesDTO().queueVisits.add(10);
        AdTitle thirdAdTitle = new AdTitle("Tercer anuncio");
        AdDescription thirdAdDescription = new AdDescription("El tercer anuncio del mundo");
        Ad thirdAd = new Ad(thirdAdTitle, thirdAdDescription, new AdDatePostedFormat("14/03/2020"));
        thirdAd.createDTO().adVisits.createAdAccessesDTO().queueVisits.add(25);

        List<Ad> ads = new ArrayList<>();
        ads.add(ad);
        ads.add(newAd);
        ads.add(thirdAd);

        SortAndRemoveTheLessVisitedAd sortAndRemoveTheLessVisitedAd = new SortAndRemoveTheLessVisitedAd();

        Assert.assertEquals(2, sortAndRemoveTheLessVisitedAd.sortAds(ads).size());
        Assert.assertEquals(adTitle, ads.get(1).createDTO().adTitle);
    }
}
