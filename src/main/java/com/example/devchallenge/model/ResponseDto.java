package com.example.devchallenge.model;

public class ResponseDto {
    private String value;
    private String result;

    public ResponseDto(String value, String result) {
        this.value = value;
        this.result = result;
    }

    public ResponseDto() {}

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResponseDto that)) return false;

        if (!getValue().equals(that.getValue())) return false;
        return getResult().equals(that.getResult());
    }

    @Override
    public int hashCode() {
        int result1 = getValue().hashCode();
        result1 = 31 * result1 + getResult().hashCode();
        return result1;
    }
}
