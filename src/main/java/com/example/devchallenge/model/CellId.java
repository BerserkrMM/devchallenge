package com.example.devchallenge.model;

import java.io.Serializable;

public class CellId implements Serializable {

    private String id;

    private String sheet;

    public CellId() {}

    public CellId(String id, String sheet) {
        this.id = id;
        this.sheet = sheet;
    }

    public String getId() {
        return id;
    }

    public String getSheet() {
        return sheet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CellId cellId)) return false;

        if (!id.equals(cellId.id)) return false;
        return sheet.equals(cellId.sheet);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + sheet.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "CellId{" +
                "id='" + id + '\'' +
                ", sheet='" + sheet + '\'' +
                '}';
    }
}
