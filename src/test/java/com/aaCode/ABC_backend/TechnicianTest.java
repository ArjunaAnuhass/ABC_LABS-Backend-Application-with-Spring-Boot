package com.aaCode.ABC_backend;

import com.aaCode.ABC_backend.dto.TechnicianRequest;
import com.aaCode.ABC_backend.modal.Technician;
import com.aaCode.ABC_backend.repository.TechnicianRepo;
import com.aaCode.ABC_backend.service.technician.TechnicianService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TechnicianTest {

    private final TechnicianService technicianService;
    private final TechnicianRepo technicianRepo;

    @Autowired
    public TechnicianTest(TechnicianService technicianService, TechnicianRepo technicianRepo) {
        this.technicianService = technicianService;
        this.technicianRepo = technicianRepo;
    }

    @Test
    public void CreateTechnician(){
        Technician technician = new Technician();

        technician.setFirstname("test7");
        technician.setLastname("test7");
        technician.setEmail("test7@gmail.com");
        technician.setPhone("83462834");
        technician.setSpecialization("test7");

        Technician results = technicianRepo.save(technician);

    }
}
