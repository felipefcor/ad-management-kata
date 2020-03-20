package domain;

import domain.Ad.Ad;
import domain.Ad.DTO.AdDTO;
import domain.Ad.AdDescription;
import domain.Ad.AdTitle;
import domain.exceptions.AdDoesNotExistException;
import domain.exceptions.RepeteadAdException;
import infrastructure.AdRepository;
import services.AdDatePosted;
import services.AdDatePostedFormat;

import java.util.List;

public class AdManagementService {
    private final AdRepository adRepository;
    private final AdDatePostedFormat adDatePostedFormat;

    public AdManagementService(AdRepository adRepository, AdDatePostedFormat adDatePostedFormat) {
        this.adRepository = adRepository;
        this.adDatePostedFormat = adDatePostedFormat;

    }

    public void add(AdTitle adTitle, AdDescription adDescription) throws RepeteadAdException {
        if (adRepository.matchAd(adTitle, adDescription)) throw new RepeteadAdException();
        adRepository.save(new Ad(adTitle, adDescription, adDatePostedFormat));
    }

    public List<Ad> getAdList() {
        return adRepository.getAdList() ;
    }

    public void remove(AdTitle adTitle) throws AdDoesNotExistException {
        if(getAd(adTitle) == null) throw new AdDoesNotExistException();
        adRepository.remove(adTitle);
    }

    public AdDTO getAd(AdTitle adTitle) {
        return adRepository.getAd(adTitle);
    }

    public void purge(AdDatePostedFormat date) {
        adRepository.purge(date);
    }
}
