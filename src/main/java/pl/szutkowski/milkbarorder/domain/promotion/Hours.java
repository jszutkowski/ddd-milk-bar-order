package pl.szutkowski.milkbarorder.domain.promotion;

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
        /**
         * @TODO implement
         */
        return true;
    }
}
