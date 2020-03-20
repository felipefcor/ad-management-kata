package infrastructure;


import domain.Ad.Ad;
import domain.user.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserRepository {

    public List<User> userList = new ArrayList<>();
    public List<Ad> favoriteAds = new ArrayList<>();

    public void save(User user) {
        this.userList.add(user);
    }

    public List<User> getUsers() {
        return this.userList;
    }

    public void favoriteAds(Ad ad) {
        this.favoriteAds.add(ad);
    }

    public List<Ad> getFavoriteAds() {
        return this.favoriteAds;
    }
}
