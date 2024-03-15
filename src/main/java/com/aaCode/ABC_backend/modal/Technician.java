package com.aaCode.ABC_backend.modal;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Transactional
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "technician")
public class Technician {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "technician_id")
    private Long technicianId;

    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String specialization;
}
