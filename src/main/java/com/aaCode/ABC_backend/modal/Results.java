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
@Table(name = "results")
public class Results {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "results_id")
    private Long id;

    private String testName;
    private String patientName;
    private String result;
    private String comment;
    private String appointmentName;
}
