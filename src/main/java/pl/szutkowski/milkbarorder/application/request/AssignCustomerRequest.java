package pl.szutkowski.milkbarorder.application.request;

public class AssignCustomerRequest {
    private String orderId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String streetName;
    private String streetNumber;
    private String apartmentNumber;
    private String postalCode;
    private String city;

    public AssignCustomerRequest(String orderId,
                                 String firstName,
                                 String lastName,
                                 String email,
                                 String phone,
                                 String streetName,
                                 String streetNumber,
                                 String apartmentNumber,
                                 String postalCode,
                                 String city) {
        this.orderId = orderId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.apartmentNumber = apartmentNumber;
        this.postalCode = postalCode;
        this.city = city;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }
}
