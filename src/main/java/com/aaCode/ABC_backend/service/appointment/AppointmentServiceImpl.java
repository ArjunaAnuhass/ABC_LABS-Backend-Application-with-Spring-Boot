package com.aaCode.ABC_backend.service.appointment;

import com.aaCode.ABC_backend.dto.AddAppointmentRequest;
import com.aaCode.ABC_backend.dto.AppointmentRequest;
import com.aaCode.ABC_backend.dto.TestRequest;
import com.aaCode.ABC_backend.modal.*;
import com.aaCode.ABC_backend.modal.enums.AppointmentStatus;
import com.aaCode.ABC_backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AppointmentServiceImpl implements AppointmentService{

    private final TestRepo testRepo;
    private final AppointmentRepo appointmentRepo;

    @Autowired
    public AppointmentServiceImpl(TestRepo testRepo, UserRepo userRepo, DoctorRepo doctorRepo, PatientRepo patientRepo, AppointmentRepo appointmentRepo, AppointmentRepo appointmentRepo1) {
        this.testRepo = testRepo;
        this.appointmentRepo = appointmentRepo1;
    }

    public Appointments addAppointment(AppointmentRequest appointmentRequest){
        Appointments appointments = new Appointments();

        appointments.setAppointmentName(appointmentRequest.getAppointmentName());
        appointments.setPatientName(appointmentRequest.getPatientName());
        appointments.setAppointmentDate(appointmentRequest.getAppointmentDate());
        appointments.setTestName(appointmentRequest.getTestName());
        appointments.setAppointmentCode(UUID.randomUUID());

        return appointmentRepo.save(appointments);
    }

    public List<Appointments> getAllAppointment(){
        return appointmentRepo.findAll();
    }

    public Appointments getAppointmentById(Long id){
        Optional<Appointments> optionalAppointments = appointmentRepo.findById(id);

        if (optionalAppointments.isPresent()){
            return optionalAppointments.get();
        }
        else {
            return null;
        }
    }

    public Appointments updateAppointment(Long id, Appointments appointments){
        Optional<Appointments> optionalAppointments = appointmentRepo.findById(id);

        if (optionalAppointments.isPresent()){
            Appointments appointments1 = optionalAppointments.get();

            appointments1.setTestName(appointments.getTestName());
            appointments1.setPatientName(appointments.getPatientName());
            appointments1.setAppointmentDate(appointments.getAppointmentDate());
            appointments1.setTestName(appointments.getTestName());

            return appointmentRepo.save(appointments1);
        }
        else {
            return null;
        }
    }


}
