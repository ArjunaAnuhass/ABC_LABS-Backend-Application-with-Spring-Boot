package com.aaCode.ABC_backend.service.results;

import com.aaCode.ABC_backend.dto.ResultRequest;
import com.aaCode.ABC_backend.modal.Results;

import java.util.List;

public interface ResultService {

    Results createAppointmentResult(ResultRequest resultRequest);

    List<Results> getAllReuslts();

    Results getResultsById(Long id);

    Results updateResults(Long id, Results results);

    boolean deleteTestResult(Long id);
}
