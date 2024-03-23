package com.aaCode.ABC_backend.service.doctor;

import com.aaCode.ABC_backend.dto.DoctorRequest;
import com.aaCode.ABC_backend.modal.Doctor;

import java.util.List;

public interface DoctorService {

    Doctor createDoctor(DoctorRequest doctorRequest);

    List<Doctor> getAllDoctors();

    Doctor getDoctorById(Long id);

    Doctor updateDoctor(Long id, Doctor doctor);

}
