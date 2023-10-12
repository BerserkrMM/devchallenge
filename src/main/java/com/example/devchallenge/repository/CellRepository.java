package com.example.devchallenge.repository;

import com.example.devchallenge.model.Cell;
import com.example.devchallenge.model.CellId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CellRepository extends JpaRepository<Cell, CellId> {
    List<Cell> findBySheet(@NonNull String sheet);
}
