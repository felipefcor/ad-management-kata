package infrastructure;

import domain.Ad.Ad;

import java.util.List;

public class SortAndRemoveTheLastAd implements SortAdsByCountry {

    @Override
    public void sortAds(List<Ad> ads) {
        ads.remove(ads.size() - 1);
        ads.sort((ad1, ad2) -> ad2.getDate().compareTo(ad1.getDate()));
    }
}
