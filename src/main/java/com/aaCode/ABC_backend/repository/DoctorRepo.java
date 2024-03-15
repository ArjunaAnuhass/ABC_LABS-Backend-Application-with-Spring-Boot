package com.aaCode.ABC_backend.repository;

import com.aaCode.ABC_backend.modal.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Long> {
}
