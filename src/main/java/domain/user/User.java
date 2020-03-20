package domain.user;

import domain.Ad.Ad;
import domain.Ad.DTO.AdDTO;
import domain.user.DTO.UserDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private UserId userId;
    public List<Ad> favoriteAds = new ArrayList<>();

    public User(UserId userId) {

        this.userId = userId;
    }
    public UserDTO createUserDTO() {
        UserDTO userDTO = new UserDTO();
        userDTO.userId = this.userId;
        return userDTO;
    }

    public void favoriteAds(Ad ad) {
        this.favoriteAds.add(ad);
    }

    public List<AdDTO> getFavoriteAds() {
        List<AdDTO> adDTOList = new ArrayList<>();
        for (Ad ad : this.favoriteAds) {
            AdDTO adDTO = ad.createDTO();;
            adDTOList.add(adDTO);
        }
        return adDTOList;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }

}
