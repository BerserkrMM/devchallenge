package com.example.devchallenge.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

@Entity
@IdClass(value = CellId.class)
public class Cell {

    @Id
    private String id;

    @Id
    private String sheet;

    private String value;

    private String result;

    public Cell() { }

    public Cell(String id, String sheet) {
        this.id = id;
        this.sheet = sheet;
    }

    public Cell(String id, String sheet, String value) {
        this.id = id;
        this.sheet = sheet;
        this.value = value;
    }

    public Cell(String id, String sheet, String value, String result) {
        this.id = id;
        this.sheet = sheet;
        this.value = value;
        this.result = result;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSheet() {
        return sheet;
    }

    public void setSheet(String sheet) {
        this.sheet = sheet;
    }

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
}
