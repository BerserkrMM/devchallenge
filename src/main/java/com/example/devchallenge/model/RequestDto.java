package com.example.devchallenge.model;

public class RequestDto {
    private String value;

    public RequestDto(String value) {
        this.value = value;
    }
    public RequestDto() { }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RequestDto that)) return false;

        return getValue().equals(that.getValue());
    }

    @Override
    public int hashCode() {
        return getValue().hashCode();
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "RequestDto{" +
                "value='" + value + '\'' +
                '}';
    }
}
