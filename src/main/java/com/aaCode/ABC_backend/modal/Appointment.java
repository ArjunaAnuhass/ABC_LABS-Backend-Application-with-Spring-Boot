package com.aaCode.ABC_backend.modal;

import com.aaCode.ABC_backend.dto.AddAppointmentRequest;
import com.aaCode.ABC_backend.modal.enums.AppointmentStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Transactional
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "appointment")

public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "test_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Test test;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime currentDateTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date appointmentDateTime;

    private AppointmentStatus appointmentStatus;

    private Long price;

//    public AddAppointmentRequest getDto(){
//        AddAppointmentRequest addAppointmentRequest = new AddAppointmentRequest();
//
//        addAppointmentRequest.setDoctorId(doctor.getId());
//        addAppointmentRequest.setPatientId(patient.getId());
//        addAppointmentRequest.setTestId(test.getTestId());
//        addAppointmentRequest.setUserId(user.getId());
//
//        addAppointmentRequest.setCurrentDateTime(currentDateTime);
//        addAppointmentRequest.setAppointmentDateTime(appointmentDateTime);
//        addAppointmentRequest.setAppointmentStatus(AppointmentStatus.Scheduled);
//        addAppointmentRequest.setPrice(price);
//
//        return addAppointmentRequest;
//    }
}
