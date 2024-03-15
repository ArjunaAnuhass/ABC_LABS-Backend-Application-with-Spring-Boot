package com.aaCode.ABC_backend.service.technician;

import com.aaCode.ABC_backend.dto.TechnicianRequest;
import com.aaCode.ABC_backend.modal.Technician;
import com.aaCode.ABC_backend.repository.TechnicianRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TechnicianServiceImpl implements TechnicianService{

    private final TechnicianRepo technicianRepo;

    public Technician createTechnician(TechnicianRequest technicianRequest){
        Technician technician = new Technician();

        technician.setFirstname(technicianRequest.getFirstname());
        technician.setLastname(technicianRequest.getLastname());
        technician.setEmail(technicianRequest.getEmail());
        technician.setPhone(technicianRequest.getPhone());
        technician.setSpecialization(technicianRequest.getSpecialization());

        return technicianRepo.save(technician);
    }

    public List<Technician> getAllTechnicians(){
        return technicianRepo.findAll();
    }

}
