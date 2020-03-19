package domain.Ad;

import java.util.Objects;

public class Ad {
    private AdTitle adTitle;
    private AdDescription adDescription;
    private String date;

    public Ad(AdTitle adTitle, AdDescription adDescription, String date) {
        this.adTitle = adTitle;
        this.adDescription = adDescription;
        this.date = date;
    }

    public AdDTO createDTO() {
        AdDTO adDTO = new AdDTO();
        adDTO.adTitle = this.adTitle;
        adDTO.adDescription = this.adDescription;
        adDTO.date = this.date;
        return adDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ad ad = (Ad) o;
        return Objects.equals(adTitle, ad.adTitle) &&
                Objects.equals(adDescription, ad.adDescription) &&
                Objects.equals(date, ad.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adTitle, adDescription, date);
    }
}
