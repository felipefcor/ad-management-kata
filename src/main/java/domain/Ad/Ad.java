package domain.Ad;

import domain.Ad.DTO.AdDTO;
import domain.Ad.DTO.AdDTODescription;
import domain.Ad.DTO.AdDTOTitle;
import domain.exceptions.TitleAndDescriptionAreTheSameException;
import domain.user.DTO.UserDTO;
import domain.user.User;
import services.AdDatePostedFormat;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ad {

    private AdTitle adTitle;
    private AdDescription adDescription;
    private AdDatePostedFormat date;
    private AdVisits adVisits = new AdVisits();
    List<User> favouriteUsers = new ArrayList<>();

    public Ad(AdTitle adTitle, AdDescription adDescription, AdDatePostedFormat date) {
        if(checkTitleAndDescription(adTitle,adDescription)) throw new TitleAndDescriptionAreTheSameException();
        this.adTitle = adTitle;
        this.adDescription = adDescription;
        this.date = date;
    }

    private boolean checkTitleAndDescription(AdTitle adTitle, AdDescription adDescription) {
        AdDTOTitle adDTOTitle = adTitle.createTitleDTO();
        AdDTODescription adDTODescription = adDescription.createDescriptionDTO();
        if (adDTOTitle.adTitle == adDTODescription.adDescription) return true;
        return false;
    }


    public AdDTO createDTO() {
        AdDTO adDTO = new AdDTO();
        adDTO.adTitle = this.adTitle;
        adDTO.adDescription = this.adDescription;
        adDTO.date = this.date;
        adDTO.adVisits = this.adVisits;

        return adDTO;
    }

    public <T> Comparable getDate() {
        return this.date.createDTOdate().adDate;
    }

    public <T> Comparable getAdTimesAccesed() {
        return this.adVisits.createAdAccessesDTO().queueVisits.element().intValue();
    }

    public void markedAsAFavouriteByAUser(User user) {
        favouriteUsers.add(user);
    }

    public List<UserDTO> getNumberOfUserMarkedAsAFavourite() {
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User user : this.favouriteUsers) {
            UserDTO userDTO = user.createUserDTO();
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ad ad = (Ad) o;
        return Objects.equals(adTitle, ad.adTitle) &&
                Objects.equals(adDescription, ad.adDescription) &&
                Objects.equals(date, ad.date) &&
                Objects.equals(adVisits, ad.adVisits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adTitle, adDescription, date, adVisits);
    }

}
