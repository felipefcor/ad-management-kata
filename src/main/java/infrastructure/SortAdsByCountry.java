package infrastructure;

import domain.Ad.Ad;

import java.util.List;

public interface SortAdsByCountry {
    List<Ad> sortAds(List<Ad> ads);

}
