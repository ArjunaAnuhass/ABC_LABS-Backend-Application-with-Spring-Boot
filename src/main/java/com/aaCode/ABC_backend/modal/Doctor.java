package com.aaCode.ABC_backend.modal;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Data
@Transactional
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private Long id;

    private String fullname;
    private String email;
    private String phone;
    private String specialization;
}
