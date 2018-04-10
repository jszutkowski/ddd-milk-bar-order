package pl.szutkowski.milkbarorder.domain.common;

public class DomainException extends Exception {

    private String fieldName;

    public DomainException(String message, String fieldName) {
        super(message);
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }
}
