package pl.szutkowski.milkbarorder.domain.customer;


public class PostalCode {
    private String postalCode;

    private PostalCode(String postalCode)
    {
        this.postalCode = postalCode;
    }

    public String postalCode()
    {
        return postalCode;
    }
}
