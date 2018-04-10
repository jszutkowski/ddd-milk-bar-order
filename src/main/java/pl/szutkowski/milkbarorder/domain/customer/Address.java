package pl.szutkowski.milkbarorder.domain.customer;

public class Address {
    private String streetName;
    private String streetNumber;
    private String apartmentNumber;
    private String city;
    private String postalCode;

    public Address(String streetName, String streetNumber, String apartmentNumber, String city, String postalCode) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.apartmentNumber = apartmentNumber;
        this.city = city;
        this.postalCode = postalCode;
    }

    public String streetName() {
        return streetName;
    }

    public String streetNumber() {
        return streetNumber;
    }

    public String apartmentNumber() {
        return apartmentNumber;
    }

    public String city() {
        return city;
    }

    public String postalCode() {
        return postalCode;
    }
}
