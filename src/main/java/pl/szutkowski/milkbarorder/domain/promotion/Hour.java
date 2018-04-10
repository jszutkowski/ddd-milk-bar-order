package pl.szutkowski.milkbarorder.domain.promotion;

public class Hour {
    private int hour;
    private int minutes;

    public Hour(int hour, int minutes) {
        this.hour = hour;
        this.minutes = minutes;
    }

    public int hour() {
        return hour;
    }

    public int minutes() {
        return minutes;
    }
}
