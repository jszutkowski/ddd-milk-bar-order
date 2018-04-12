package pl.szutkowski.milkbarorder.domain.promotion;

import java.util.Calendar;

public class Hours {
    private Hour hourFrom;
    private Hour hourTo;

    public Hours(Hour hourFrom, Hour hourTo) {
        this.hourFrom = hourFrom;
        this.hourTo = hourTo;
    }

    public static Hours create(int hourFrom, int minutesFrom, int hourTo, int minutesTo) {
        Hour timeFrom = new Hour(hourFrom, minutesFrom);
        Hour timeTo = new Hour(hourTo, minutesTo);

        return new Hours(timeFrom, timeTo);
    }

    public boolean isBetween() {

        Calendar calendar = Calendar.getInstance();
        int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
        int currentMinutes = calendar.get(Calendar.MINUTE);

        if (currentHour < hourFrom.hour() || currentHour > hourTo.hour()) {
            return false;
        }

        if (currentHour == hourFrom.hour() && currentMinutes < hourFrom.minutes()) {
            return false;
        }

        if (currentHour == hourTo.hour() && currentMinutes > hourTo.minutes()) {
            return false;
        }

        return true;
    }
}
