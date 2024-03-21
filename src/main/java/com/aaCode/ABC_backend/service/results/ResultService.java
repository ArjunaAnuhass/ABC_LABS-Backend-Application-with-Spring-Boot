package com.aaCode.ABC_backend.service.results;

import com.aaCode.ABC_backend.dto.ResultRequest;
import com.aaCode.ABC_backend.modal.Results;

public interface ResultService {

    Results createAppointmentResult(ResultRequest resultRequest);
}
