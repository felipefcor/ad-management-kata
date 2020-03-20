package infrastructure;

public class AdRepositoryInMemoryExpireByOldestAd extends AdRepositoryInMemory {
    public AdRepositoryInMemoryExpireByOldestAd() {
        sortAdsByCountry = new SortAndRemoveTheLastAd();
    }
}
