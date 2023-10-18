package com.example.devchallenge.model;

import java.util.Map;

public class SheetResponseDto {

    private Map<String,ResponseDto> responseDtoMap;

    public Map<String, ResponseDto> getResponseDtoMap() {
        return responseDtoMap;
    }

    public void setResponseDtoMap(Map<String, ResponseDto> responseDtoMap) {
        this.responseDtoMap = responseDtoMap;
    }

    public SheetResponseDto(Map<String, ResponseDto> responseDtoMap) {
        this.responseDtoMap = responseDtoMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SheetResponseDto that)) return false;

        return getResponseDtoMap().equals(that.getResponseDtoMap());
    }

    @Override
    public int hashCode() {
        return getResponseDtoMap().hashCode();
    }

    @Override
    public String toString() {
        return "SheetResponseDto{" +
                "responseDtoMap=" + responseDtoMap +
                '}';
    }
}
