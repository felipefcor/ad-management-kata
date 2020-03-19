package infrastructure;

import domain.Ad.Ad;
import domain.Ad.AdDTO;
import domain.Ad.AdDescription;
import domain.Ad.AdTitle;

import java.util.ArrayList;
import java.util.List;

public class AdRepositoryInMemory implements AdRepository {
    List<Ad> adList = new ArrayList<>();

    @Override
    public void save(Ad ad) {
        adList.add(ad);
    }

    @Override
    public Boolean matchAd(AdTitle adTitle, AdDescription adDescription) {
        for (Ad ad : adList) {
            AdDTO adDTO = ad.createDTO();
            if(adDTO.adTitle.equals(adTitle) && adDTO.adDescription.equals(adDescription)) return true;
        }
        return false;
    }
}