package pl.szutkowski.milkbarorder.domain;

public class Assert {

    public static void assertNotNull(Object object, String aMessage) {
        if (object == null) {
            throw new IllegalArgumentException(aMessage);
        }
    }

    public static void assertArgumentMinLength(String aString, int minLength, String aMessage) {

        if (aString.length() < minLength) {
            throw new IllegalArgumentException(aMessage);
        }
    }

    public static void assertGreaterThanOrEqual(int aNumber, int minValue, String aMessage) {
        if (aNumber < minValue) {
            throw new IllegalArgumentException(aMessage);
        }
    }

    public static void assertGreaterThan(int aNumber, int minValue, String aMessage) {
        if (aNumber <= minValue) {
            throw new IllegalArgumentException(aMessage);
        }
    }

    public static void assertLessThanOrEqual(int aNumber, int maxValue, String aMessage) {
        if (aNumber > maxValue) {
            throw new IllegalArgumentException(aMessage);
        }
    }

    public static void assertLessThan(int aNumber, int maxValue, String aMessage) {
        if (aNumber >= maxValue) {
            throw new IllegalArgumentException(aMessage);
        }
    }

    public static void assertBetween(int aNumber, int minValue, int maxValue, String aMessage) {
        if (aNumber < minValue || aNumber > maxValue) {
            throw new IllegalArgumentException(aMessage);
        }
    }
}
