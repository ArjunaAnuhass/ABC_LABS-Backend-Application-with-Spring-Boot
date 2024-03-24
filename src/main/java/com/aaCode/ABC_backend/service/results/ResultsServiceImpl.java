package com.aaCode.ABC_backend.service.results;

import com.aaCode.ABC_backend.dto.ResultRequest;
import com.aaCode.ABC_backend.modal.Doctor;
import com.aaCode.ABC_backend.modal.Results;
import com.aaCode.ABC_backend.modal.Test;
import com.aaCode.ABC_backend.repository.ResultsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<Results> getAllReuslts(){
        return resultsRepo.findAll();
    }

    public Results getResultsById(Long id){
        Optional<Results> optionalResults = resultsRepo.findById(id);

        if (optionalResults.isPresent()){
            return optionalResults.get();
        }
        else {
            return null;
        }
    }

    public Results updateResults(Long id, Results results){
        Optional<Results> optionalResults = resultsRepo.findById(id);

        if (optionalResults.isPresent()){
            Results results1 = optionalResults.get();

            results1.setTestName(results.getTestName());
            results1.setPatientName(results.getPatientName());
            results1.setResult(results.getResult());
            results1.setComment(results.getComment());
            results1.setAppointmentName(results.getAppointmentName());

            return resultsRepo.save(results1);
        }
        else {
            return null;
        }
    }

    public boolean deleteTestResult(Long id){
        Optional<Results> optionalResults = resultsRepo.findById(id);
        if (optionalResults.isPresent()){
            resultsRepo.deleteById(id);

            return true;
        }
        return false;
    }
}
