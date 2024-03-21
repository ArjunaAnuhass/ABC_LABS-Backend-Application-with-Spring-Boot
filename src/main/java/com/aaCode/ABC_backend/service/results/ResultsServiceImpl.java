package com.aaCode.ABC_backend.service.results;

import com.aaCode.ABC_backend.dto.ResultRequest;
import com.aaCode.ABC_backend.modal.Results;
import com.aaCode.ABC_backend.repository.ResultsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultsServiceImpl implements ResultService{

    private final ResultsRepo resultsRepo;

    @Autowired
    public ResultsServiceImpl(ResultsRepo resultsRepo) {
        this.resultsRepo = resultsRepo;
    }

    public Results createAppointmentResult(ResultRequest resultRequest){
        Results results = new Results();

        results.setTestName(resultRequest.getTestName());
        results.setPatientName(resultRequest.getPatientName());
        results.setResult(resultRequest.getResult());
        results.setComment(resultRequest.getComment());
        results.setAppointmentName(resultRequest.getAppointmentName());

        return resultsRepo.save(results);
    }
}
