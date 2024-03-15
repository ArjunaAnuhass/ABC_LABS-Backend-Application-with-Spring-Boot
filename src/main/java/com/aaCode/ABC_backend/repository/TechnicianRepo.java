package com.aaCode.ABC_backend.repository;

import com.aaCode.ABC_backend.modal.Technician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
@EnableJpaRepositories
public interface TechnicianRepo extends JpaRepository<Technician, Long> {

    Optional<Technician> findById(Long technicianId);
}
