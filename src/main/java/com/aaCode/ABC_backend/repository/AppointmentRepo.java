package com.aaCode.ABC_backend.repository;

import com.aaCode.ABC_backend.modal.Appointment;
import com.aaCode.ABC_backend.modal.Appointments;
import com.aaCode.ABC_backend.modal.enums.PaymentStatus;
import org.hibernate.query.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointments, Long> {
}
