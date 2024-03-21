package com.aaCode.ABC_backend.controller;

import com.aaCode.ABC_backend.dto.ResultRequest;
import com.aaCode.ABC_backend.modal.Results;
import com.aaCode.ABC_backend.service.results.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "api/v1/results")
public class ResultsController {

    private final ResultService resultService;

    @Autowired
    public ResultsController(ResultService resultService) {
        this.resultService = resultService;
    }

    @PostMapping(path = "createResult")
    public ResponseEntity<Results> createResults(@RequestBody ResultRequest resultRequest){
        Results results = resultService.createAppointmentResult(resultRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(results);
    }
}
