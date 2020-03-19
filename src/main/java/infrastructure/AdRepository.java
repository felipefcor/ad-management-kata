package infrastructure;

import domain.Ad.Ad;
import domain.Ad.AdDTO;
import domain.Ad.AdDescription;
import domain.Ad.AdTitle;

import java.util.List;

public interface AdRepository {
    void save(Ad ad);

    Boolean matchAd(AdTitle adTitle, AdDescription adDescription);

    List<Ad> getAdList();
}

