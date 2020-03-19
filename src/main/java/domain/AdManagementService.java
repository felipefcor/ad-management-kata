package domain;

import domain.Ad.Ad;
import domain.Ad.AdDTO;
import domain.Ad.AdDescription;
import domain.Ad.AdTitle;
import domain.exceptions.RepeteadAdException;
import infrastructure.AdRepository;
import services.AdDatePosted;

public class AdManagementService {
    private final AdRepository adRepository;
    private final AdDatePosted adDatePosted;

    public AdManagementService(AdRepository adRepository, AdDatePosted adDatePosted) {
        this.adRepository = adRepository;
        this.adDatePosted = adDatePosted;
    }

    public void add(AdTitle adTitle, AdDescription adDescription) throws RepeteadAdException {

        if (adRepository.matchAd(adTitle, adDescription)) throw new RepeteadAdException();
        adRepository.save(new Ad(adTitle, adDescription, adDatePosted.getDate()));

    }

}
