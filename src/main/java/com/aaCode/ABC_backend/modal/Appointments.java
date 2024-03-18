package com.aaCode.ABC_backend.modal;

import com.aaCode.ABC_backend.dto.AppointmentRequest;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Transactional
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "appointments")
public class Appointments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointments_id")
    private Long id;

    private String appointmentName;
    private String patientName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date appointmentDate;

    private String testName;

    private UUID appointmentCode;


//    public AppointmentRequest getDto(){
//        AppointmentRequest appointmentRequest = new AppointmentRequest();
//
//        appointmentRequest.setId(id);
//        appointmentRequest.setAppointmentName(appointmentName);
//        appointmentRequest.setPatientName(patientName);
//        appointmentRequest.setAppointmentDate(appointmentDate);
//        appointmentRequest.setTesId(test.getTestId());
//        appointmentRequest.setAppointmentCode(appointmentCode);
//
//        return appointmentRequest;
//    }
}
