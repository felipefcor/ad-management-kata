package infrastructure;

import domain.Ad.Ad;
import domain.Ad.DTO.AdDTO;
import domain.Ad.AdDescription;
import domain.Ad.AdTitle;
import services.AdDatePostedFormat;
import services.DTOdate;

import java.time.LocalDateTime;
import java.util.*;

public class AdRepositoryInMemory implements AdRepository {
    List<Ad> adList = new ArrayList<>();

    @Override
    public void save(Ad ad) {
        if (this.adList.size() == 100) sortListAdsbyDate();
        this.adList.add(ad);
    }

    private void sortListAdsbyDate() {
        this.adList.remove(this.adList.size() - 1);
        this.adList.sort((ad1, ad2) -> ad2.getDate().compareTo(ad1.getDate()));
    }


    @Override
    public Boolean matchAd(AdTitle adTitle, AdDescription adDescription) {
        for (Ad ad : this.adList) {
            AdDTO adDTO = ad.createDTO();
            if(adDTO.adTitle.equals(adTitle) && adDTO.adDescription.equals(adDescription)) return true;
        }
        return false;
    }

    @Override
    public List<Ad> getAdList() {
        return this.adList;
    }

    @Override
    public void remove(AdTitle adTitle) {
     for (Ad ad : this.adList) {
         AdDTO adDTO = ad.createDTO();
         if(adDTO.adTitle.equals(adTitle)) adList.remove(ad);
        }
    }

    @Override
    public AdDTO getAd(AdTitle adTitle) {
        for (Ad ad : this.adList) {
            AdDTO adDTO = ad.createDTO();
            if(adDTO.adTitle.equals(adTitle)) return adDTO;
        }
        return null;
    }

    @Override
    public void purge(AdDatePostedFormat adDate) {
        DTOdate dtoDate  = adDate.createDTOdate();

        for (Iterator<Ad> adList = this.adList.iterator(); adList.hasNext(); ) {
            Ad newAd = adList.next();
            AdDTO adDTO = newAd.createDTO();
            DTOdate newDateDTO = adDTO.date.createDTOdate();
            Date dateFormmattedList = newDateDTO.adDate;
            if (dateFormmattedList.before(dtoDate.adDate)) adList.remove();
        }
    }
}