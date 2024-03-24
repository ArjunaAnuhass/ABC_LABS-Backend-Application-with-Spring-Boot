package com.aaCode.ABC_backend.controller;

import com.aaCode.ABC_backend.dto.ResultRequest;
import com.aaCode.ABC_backend.modal.Patient;
import com.aaCode.ABC_backend.modal.Results;
import com.aaCode.ABC_backend.service.results.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "api/v1/results")
public class ResultsController {

    private final ResultService resultService;

    @Autowired
    public ResultsController(ResultService resultService) {
        this.resultService = resultService;
    }

    @PostMapping(path = "/createResult")
    public ResponseEntity<Results> createResults(@RequestBody ResultRequest resultRequest){
        Results results = resultService.createAppointmentResult(resultRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(results);
    }

    @GetMapping(path = "/getAllResults")
    public ResponseEntity<List<Results>> getAllResults(){
        return ResponseEntity.ok(resultService.getAllReuslts());
    }

    @GetMapping(path = "/getResultsById/{id}")
    public ResponseEntity<Results> getResultsById(@PathVariable Long id){
        Results results = resultService.getResultsById(id);

        if (results != null){
            return ResponseEntity.ok(results);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(path = "/updateResults/{id}")
    public ResponseEntity<Results> updateResults(@PathVariable Long id, @ModelAttribute Results results){
        Results updateResults = resultService.updateResults(id, results);

        if (updateResults != null){
            return ResponseEntity.ok(updateResults);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/deleteTestResult/{id}")
    public ResponseEntity<Void> deleteTestResult(@PathVariable Long id){
        boolean deleted = resultService.deleteTestResult(id);
        if (deleted){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
