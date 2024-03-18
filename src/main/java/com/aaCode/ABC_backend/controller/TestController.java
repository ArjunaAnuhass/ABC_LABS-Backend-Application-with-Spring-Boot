package com.aaCode.ABC_backend.controller;

import com.aaCode.ABC_backend.dto.TestRequest;
import com.aaCode.ABC_backend.modal.Test;
import com.aaCode.ABC_backend.service.test.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/test")
@CrossOrigin("*")
public class TestController {

    private final TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @PostMapping(path = "/createTest")
    public ResponseEntity<TestRequest> addTest(@ModelAttribute TestRequest testRequest){
        TestRequest testRequest1 = testService.createTest(testRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(testRequest1);
    }

    @GetMapping(path = "/getAllTests")
    public ResponseEntity<List<TestRequest>> getAllTest(){
        List<TestRequest> testRequests = testService.getAllTests();

        return ResponseEntity.ok(testRequests);
    }

    @GetMapping(path = "/search/{testName}")
    public ResponseEntity<List<TestRequest>> getAllTestsByName(@PathVariable String testName){
        List<TestRequest>  testRequests =testService.getAllTestByTestName(testName);

        return ResponseEntity.ok(testRequests);
    }

    @DeleteMapping(path = "/deleteTest/{testId}")
    public ResponseEntity<Void> deleteTests(@PathVariable Long testId){
        boolean deleted = testService.deleteTest(testId);
        if (deleted){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


}
