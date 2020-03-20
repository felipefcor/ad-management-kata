package services;

import domain.Ad.DTO.AdDTODescription;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Objects;

public class AdDatePostedFormat implements AdDatePosted {
    public Date adDate;

    public AdDatePostedFormat(String adDate) {
        this.adDate = getDateFormatted(adDate);
    }

    @Override
    public String getDate() {
        return null;
    }

    @Override
    public Date getDateFormatted(String adDate) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        ParsePosition parsePosition = new ParsePosition(0);
        Date date = dateFormat.parse(adDate, parsePosition);
        return date;
    }

    public DTOdate createDTOdate() {
        DTOdate dtoDate = new DTOdate();
        dtoDate.adDate = this.adDate;
        return dtoDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdDatePostedFormat that = (AdDatePostedFormat) o;
        return Objects.equals(adDate, that.adDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adDate);
    }


}
