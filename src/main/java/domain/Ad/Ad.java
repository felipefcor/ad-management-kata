package domain.Ad;

public class Ad {
    private final AdTitle adTitle;
    private final AdDescription adDescription;
    private final String date;

    public Ad(AdTitle adTitle, AdDescription adDescription, String date) {
        this.adTitle = adTitle;
        this.adDescription = adDescription;
        this.date = date;
    }
}
