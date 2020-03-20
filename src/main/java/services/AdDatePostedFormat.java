package services;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class AdDatePostedFormat implements AdDatePosted {
    public String adDate;

    public AdDatePostedFormat(String adDate) {
        this.adDate = adDate;
    }

    @Override
    public String getDate() {
        return this.adDate;
    }

    @Override
    public Date getDateFormatted() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        ParsePosition parsePosition = new ParsePosition(0);
        Date date = dateFormat.parse(this.adDate, parsePosition);
        return date;
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
