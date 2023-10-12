package com.example.devchallenge.service;

import com.example.devchallenge.model.Cell;
import com.example.devchallenge.model.CellId;
import com.example.devchallenge.model.ResponseDto;
import com.example.devchallenge.repository.CellRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Service
public class Service {

    private static final String ERROR = "ERROR";

    private final CellRepository repository;

    public Service(CellRepository repository) {
        this.repository = repository;
    }

    public ResponseDto upsert(final String sheetId, final String cellId, final String value) {
        ResponseDto response = new ResponseDto();
        response.setValue(value);
        final String result = resolveValue(sheetId, cellId, value);

        if (result.equals(ERROR)) {
            response.setResult(result);
            return response;
        }

        final Cell updatedCell = new Cell(cellId, sheetId, value, result);
        final Cell cellToUpsert = repository.save(updatedCell);
        response.setResult(cellToUpsert.getResult());

        return response;
    }

    public ResponseDto getBySheetAndCellId(final String sheetId, final String cellId) {
        var cellOptional = repository.findById(new CellId(cellId, sheetId));
        if (cellOptional.isEmpty()) return new ResponseDto();


        return ResponseDto.builder()
                .value(cellOptional.get().getValue())
                .result(cellOptional.get().getResult())
                .build();
    }

    public Map<String, ResponseDto> getAllInSheet(final String sheetId) {
        var cellList = repository.findBySheet(sheetId);
        if (cellList.isEmpty()) return new HashMap<String, ResponseDto>();

        Map<String, ResponseDto> map = new HashMap<>();
        for (Cell cell : cellList) {
            map.put(cell.getId(), new ResponseDto(cell.getValue(), cell.getResult()));
        }

        return map;
    }

    private String resolveValue(final String sheetId, final String cellId, final String value) {
        if (value.matches("=\\S*\\+\\S*")) {

            final String[] ids = value.substring(1).split("\\+");
            List<Integer> values = new ArrayList<>();

            for (String cid : ids) {
                var cell = repository.findById(new CellId(cid, sheetId));
                if (cell.isEmpty() || cell.get().getId().equals(cellId)) return ERROR;
                values.add(Integer.valueOf(cell.get().getResult()));
            }

            var sum = values.stream().reduce(Integer::sum);
            return sum.isEmpty() ? ERROR : sum.get().toString();
        }
        return value;
    }
}
