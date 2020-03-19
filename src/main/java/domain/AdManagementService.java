package domain;

import domain.Ad.Ad;
import infrastructure.AdRepository;
import services.AdDatePosted;

public class AdManagementService {
    private final AdRepository adRepository;
    private final AdDatePosted adDatePosted;

    public AdManagementService(AdRepository adRepository, AdDatePosted adDatePosted) {
        this.adRepository = adRepository;
        this.adDatePosted = adDatePosted;
    }

    public void add(Ad ad) {
        adRepository.save(ad);
    }
}
