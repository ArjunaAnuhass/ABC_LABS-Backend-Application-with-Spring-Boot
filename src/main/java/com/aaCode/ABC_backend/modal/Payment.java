//package com.aaCode.ABC_backend.modal;
//
//import com.aaCode.ABC_backend.modal.enums.Method;
//import com.aaCode.ABC_backend.modal.enums.PaymentStatus;
//import com.fasterxml.jackson.annotation.JsonFormat;
//import jakarta.persistence.*;
//import lombok.*;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.UUID;
//
//@Entity
//@Data
//@Transactional
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Table(name = "payment")
//
//public class Payment {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "payment_id")
//    private Long id;
//
//    private Long amount;
//    private Long totalAmount;
//
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    private LocalDateTime paymentDate;
//
//    private Method method;
//    private PaymentStatus paymentStatus;
//    private UUID paymentTrackingId;
//
//    @OneToOne(cascade = CascadeType.MERGE)
//    @JoinColumn(name = "id")
//    private User user;
//
//}
