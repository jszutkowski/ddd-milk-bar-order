package pl.szutkowski.milkbarorder.application.request;

import lombok.Data;

@Data
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
}
