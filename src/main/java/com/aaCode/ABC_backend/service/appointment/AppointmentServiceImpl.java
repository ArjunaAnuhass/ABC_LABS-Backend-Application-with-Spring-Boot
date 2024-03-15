package com.aaCode.ABC_backend.service.appointment;

import com.aaCode.ABC_backend.dto.AddAppointmentRequest;
import com.aaCode.ABC_backend.modal.*;
import com.aaCode.ABC_backend.modal.enums.AppointmentStatus;
import com.aaCode.ABC_backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService{

    private final TestRepo testRepo;
    private final UserRepo userRepo;
    private final DoctorRepo doctorRepo;
    private final PatientRepo patientRepo;
    private final AppointmentRepo appointmentRepo;

    @Autowired
    public AppointmentServiceImpl(TestRepo testRepo, UserRepo userRepo, DoctorRepo doctorRepo, PatientRepo patientRepo, AppointmentRepo appointmentRepo) {
        this.testRepo = testRepo;
        this.userRepo = userRepo;
        this.doctorRepo = doctorRepo;
        this.patientRepo = patientRepo;
        this.appointmentRepo = appointmentRepo;
    }


    public boolean makeAppointment(AddAppointmentRequest addAppointmentRequest){
        Optional<User> optionalUser = userRepo.findById(addAppointmentRequest.getUserId());
        Optional<Test> optionalTest = testRepo.findById(addAppointmentRequest.getTestId());

        if (optionalTest.isPresent() && optionalUser.isPresent()){
            Appointment appointment = new Appointment();
            Test test = optionalTest.get();

            appointment.setUser(optionalUser.get());

            Test test1 = testRepo.findById(addAppointmentRequest.getTestId()).orElseThrow();
            appointment.setTest(test1);

            Doctor doctor = doctorRepo.findById(addAppointmentRequest.getDoctorId()).orElseThrow();
            appointment.setDoctor(doctor);

            Patient patient = patientRepo.findById(addAppointmentRequest.getPatientId()).orElseThrow();
            appointment.setPatient(patient);

            appointment.setAppointmentStatus(AppointmentStatus.Scheduled);
            appointment.setCurrentDateTime(addAppointmentRequest.getCurrentDateTime());
            appointment.setAppointmentDateTime(addAppointmentRequest.getAppointmentDateTime());
            appointment.setPrice(test.getPrice());

            appointmentRepo.save(appointment);
            return true;


        }
        return false;
    }
}
