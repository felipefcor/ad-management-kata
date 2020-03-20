package infrastructure;

import domain.Ad.Ad;
import java.util.List;

public class SortAndRemoveTheLessVisitedAd implements SortAdsByCountry {

    @Override
    public List<Ad> sortAds(List<Ad> ads) {
        ads.sort((ad1, ad2) -> ad2.getAdTimesAccesed().compareTo(ad1.getAdTimesAccesed()));
        ads.remove(ads.size() - 1);
        return ads;
    }
}
