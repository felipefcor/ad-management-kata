package infrastructure;

import domain.Ad.Ad;
import java.util.List;

public class SortAndRemoveTheLastAd implements SortAdsByCountry {

    @Override
    public List<Ad> sortAds(List<Ad> ads) {
        ads.sort((ad1, ad2) -> ad2.getDate().compareTo(ad1.getDate()));
        ads.remove(ads.size() - 1);
        return ads;
    }
}
