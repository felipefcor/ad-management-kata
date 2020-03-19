package infrastructure;

import domain.Ad.Ad;

import java.util.ArrayList;
import java.util.List;

public class AdRepositoryInMemory implements AdRepository {
    List adList = new ArrayList<>();

    @Override
    public void save(Ad ad) {
        adList.add(ad);
    }
}
