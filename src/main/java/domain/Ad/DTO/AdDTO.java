package domain.Ad.DTO;

import domain.Ad.AdAccesses;
import domain.Ad.AdDescription;
import domain.Ad.AdTitle;
import services.AdDatePostedFormat;

import java.util.Objects;

public class AdDTO {
    public AdTitle adTitle;
    public AdDescription adDescription;
    public AdDatePostedFormat date;
    public AdAccesses adAccesses;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdDTO adDTO = (AdDTO) o;
        return adAccesses == adDTO.adAccesses &&
                Objects.equals(adTitle, adDTO.adTitle) &&
                Objects.equals(adDescription, adDTO.adDescription) &&
                Objects.equals(date, adDTO.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adTitle, adDescription, date, adAccesses);
    }
}
