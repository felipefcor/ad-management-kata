package infrastructure;

public class AdRepositoryInMemoryExpireByLessVisitedAd extends AdRepositoryInMemory {
    public AdRepositoryInMemoryExpireByLessVisitedAd() {
        sortAdsByCountry = new SortAndRemoveTheLessVisitedAd();
    }
}
