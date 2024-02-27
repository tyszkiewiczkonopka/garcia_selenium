package providers;

public enum ImageName {

    COMPASS("compass"),
    CALENDAR("calendar"),
    AWARD("award"),
    LANDSCAPE("landscape");

    private final String value;

    ImageName(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

