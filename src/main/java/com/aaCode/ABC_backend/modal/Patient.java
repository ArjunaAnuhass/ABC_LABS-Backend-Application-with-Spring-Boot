package com.aaCode.ABC_backend.modal;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

@Entity
@Data
@Transactional
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "patient")
public class Patient implements Serializable {

    @Id
    @Column(name = "patient_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullname;
    private String address;
    private String email;
    private String phone;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dob;

    private String medicalHistory;
    private String patientCode;

}
