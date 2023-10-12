package com.example.devchallenge.controller;

import com.example.devchallenge.model.Cell;
import com.example.devchallenge.model.RequestDto;
import com.example.devchallenge.model.ResponseDto;
import com.example.devchallenge.service.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1")
public class Controller {

    private static final Logger LOG = LoggerFactory.getLogger("Controller Logger");

    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @PostMapping(value = "/{sheet_id}/{cell_id}")
    public ResponseEntity<ResponseDto> upsert(
            @PathVariable("sheet_id") final String sheetId,
            @PathVariable("cell_id") final String cellId,
            @RequestBody final RequestDto request
    ) {
        var response = service.upsert(sheetId, cellId, request.getValue());

        if (response.getResult().equals("ERROR")) {
            return new ResponseEntity<>(response, HttpStatus.UNPROCESSABLE_ENTITY);
        } else return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{sheet_id}/{cell_id}")
    public ResponseEntity<ResponseDto> getBySheetAndCellId(
            @PathVariable("sheet_id") final String sheetId,
            @PathVariable("cell_id") final String cellId
    ) {
        var response = service.getBySheetAndCellId(sheetId, cellId);

        if (response.getValue() == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/{sheet_id}")
    public ResponseEntity<Map<String,ResponseDto>> getAllInSheet(
            @PathVariable("sheet_id") final String sheetId
    ) {
        var response = service.getAllInSheet(sheetId);

        if (response.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
