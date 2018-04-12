package pl.szutkowski.milkbarorder.domain.promotion;

import pl.szutkowski.milkbarorder.domain.Assert;

public class Hour {

    private static int MIN_HOUR = 0;
    private static int MAX_HOUR = 23;
    private static int MIN_MINUTE = 0;
    private static int MAX_MINUTE = 59;

    private int hour;
    private int minutes;

    public Hour(int hour, int minutes) {

        Assert.assertBetween(hour, MIN_HOUR, MAX_HOUR, "Invalid hour");
        Assert.assertBetween(hour, MIN_MINUTE, MAX_MINUTE, "Invalid minute");

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
