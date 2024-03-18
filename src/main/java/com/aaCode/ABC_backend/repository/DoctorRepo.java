package com.aaCode.ABC_backend.repository;

import com.aaCode.ABC_backend.modal.Doctor;
import com.aaCode.ABC_backend.modal.Technician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Long> {
}
