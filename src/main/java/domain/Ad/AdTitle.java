package domain.Ad;

import java.util.Objects;

public class AdTitle {
    private String adTitle;

    public AdTitle(String adTitle) {
        this.adTitle = adTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdTitle adTitle1 = (AdTitle) o;
        return Objects.equals(adTitle, adTitle1.adTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adTitle);
    }
}

