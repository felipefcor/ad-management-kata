package infrastructure;

import domain.Ad.Ad;
import domain.Ad.DTO.AdDTO;
import domain.Ad.AdDescription;
import domain.Ad.AdTitle;
import services.AdDatePostedFormat;

import java.util.List;

public interface AdRepository {
    void save(Ad ad);

    Boolean matchAd(AdTitle adTitle, AdDescription adDescription);

    List<Ad> getAdList();

    void remove(AdTitle adTitle);

    AdDTO getAd(AdTitle adTitle);

    void purge(AdDatePostedFormat date);
}

