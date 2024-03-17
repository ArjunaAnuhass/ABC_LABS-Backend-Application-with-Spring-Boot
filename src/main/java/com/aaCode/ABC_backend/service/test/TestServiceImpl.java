package com.aaCode.ABC_backend.service.test;

import com.aaCode.ABC_backend.dto.TestRequest;
import com.aaCode.ABC_backend.modal.Technician;
import com.aaCode.ABC_backend.modal.Test;
import com.aaCode.ABC_backend.repository.TechnicianRepo;
import com.aaCode.ABC_backend.repository.TestRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class TestServiceImpl implements TestService{

    private final TestRepo testRepo;
    private final TechnicianRepo technicianRepo;

    @Autowired
    public TestServiceImpl(TestRepo testRepo, TechnicianRepo technicianRepo) {
        super();
        this.testRepo = testRepo;
        this.technicianRepo = technicianRepo;
    }

    public TestRequest createTest(TestRequest testRequest){
        Test test = new Test();

        test.setTestName(testRequest.getTestName());
        test.setDescription(testRequest.getDescription());
        test.setPrice(testRequest.getPrice());

        Technician technician = technicianRepo.findById(testRequest.getTechId()).orElseThrow();
        test.setTechnician(technician);

        return testRepo.save(test).getRequestDto();


    }

    public List<TestRequest> getAllTests(){
        List<Test> tests = testRepo.findAll();

        return tests.stream().map(Test::getRequestDto).collect(Collectors.toList());
    }

    public List<TestRequest> getAllTestByTestName(String testName){
        List<Test> tests = testRepo.findAllByTestNameContaining(testName);

        return tests.stream().map(Test::getRequestDto).collect(Collectors.toList());
    }

//    public boolean deleteTest(Long id){
//        Optional<Test> optionalTest = testRepo.findById(id);
//        if (optionalTest.isPresent()){
//            testRepo.deleteById(id);
//
//            return true;
//        }
//        return false;
//    }
}
