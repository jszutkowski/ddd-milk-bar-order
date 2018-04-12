package pl.szutkowski.milkbarorder.domain.promotion;

import pl.szutkowski.milkbarorder.domain.Assert;

import java.util.Calendar;
import java.util.List;

public class Days {

    private static final int MIN_DAY = 1;
    private static final int MAX_DAY = 7;

    private List<Integer> days;

    public Days(List<Integer> days) {

        for(Integer day : days) {
            Assert.assertBetween(day, MIN_DAY, MAX_DAY, "Invalid day number");
        }
        this.days = days;
    }

    public boolean hasCurrentDay() {

        int currentDay = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        for (int day : days) {
            if (day == currentDay) {
                return true;
            }
        }

        return false;
    }
}
