package com.aaCode.ABC_backend.modal;

import com.aaCode.ABC_backend.dto.TestRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "test")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_id")
    private Long testId;

    private String testName;
    private String description;
    private Long price;

    @ManyToOne
    @JoinColumn(name = "technician_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Technician technician;


    public TestRequest getRequestDto(){
        TestRequest testRequest = new TestRequest();

        testRequest.setTestId(testId);
        testRequest.setTestName(testName);
        testRequest.setDescription(description);
        testRequest.setPrice(price);
        testRequest.setCateId(technician.getTechnicianId());

        return testRequest;
    }
}
