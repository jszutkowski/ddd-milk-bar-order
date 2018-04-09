package pl.szutkowski.milkbarorder.domain.customer;

public class Customer {
    private CustomerId id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Email email;
    private Address address;

    public Customer(CustomerId id, String firstName, String lastName, String phoneNumber, Email email, Address address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public CustomerId id() {
        return id;
    }

    public String firstName() {
        return firstName;
    }

    public String lastName() {
        return lastName;
    }

    public String phoneNumber() {
        return phoneNumber;
    }

    public Email email() {
        return email;
    }

    public Address address() {
        return address;
    }
}
