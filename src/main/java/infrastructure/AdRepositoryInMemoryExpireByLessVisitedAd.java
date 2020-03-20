package infrastructure;

import infrastructure.AdRepositoryInMemory;

public class AdRepositoryInMemoryExpireByLessVisitedAd extends AdRepositoryInMemory {
    public AdRepositoryInMemoryExpireByLessVisitedAd() {
        sortAdsByCountry = new SortAndRemoveTheLessVisitedAd();
    }
}
