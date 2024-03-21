package com.aaCode.ABC_backend.repository;

import com.aaCode.ABC_backend.modal.Results;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultsRepo extends JpaRepository<Results, Long> {
}
