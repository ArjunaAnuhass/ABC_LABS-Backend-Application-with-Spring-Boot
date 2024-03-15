package com.aaCode.ABC_backend.service.technician;

import com.aaCode.ABC_backend.dto.TechnicianRequest;
import com.aaCode.ABC_backend.modal.Technician;

import java.util.List;

public interface TechnicianService {

    Technician createTechnician(TechnicianRequest technicianRequest);

    List<Technician> getAllTechnicians();
}
