package infrastructure;


import domain.Ad.Ad;
import domain.Ad.DTO.AdDTO;
import domain.user.DTO.UserDTO;
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

    public List<UserDTO> getUsers() {
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User user : this.userList) {
            UserDTO userDTO = user.createUserDTO();
            userDTOList.add(userDTO);
        }
        return userDTOList;
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
}
