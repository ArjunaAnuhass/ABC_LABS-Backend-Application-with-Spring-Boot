package com.aaCode.ABC_backend.service.doctor;

import com.aaCode.ABC_backend.dto.DoctorRequest;
import com.aaCode.ABC_backend.modal.Doctor;
import com.aaCode.ABC_backend.repository.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService{

    private final DoctorRepo doctorRepo;

    @Autowired
    public DoctorServiceImpl(DoctorRepo doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    public Doctor createDoctor(DoctorRequest doctorRequest){
        Doctor doctor = new Doctor();

        doctor.setFullname(doctorRequest.getFullname());
        doctor.setEmail(doctorRequest.getEmail());
        doctor.setPhone(doctorRequest.getPhone());
        doctor.setSpecialization(doctorRequest.getSpecialization());

        return doctorRepo.save(doctor);
    }

    public List<Doctor> getAllDoctors(){
        return doctorRepo.findAll();
    }
}
