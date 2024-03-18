package com.aaCode.ABC_backend.service.test;

import com.aaCode.ABC_backend.dto.TestRequest;
import com.aaCode.ABC_backend.modal.Test;

import java.io.IOException;
import java.util.List;

public interface TestService {

    TestRequest createTest(TestRequest testRequest);

    List<TestRequest> getAllTests();

    List<TestRequest> getAllTestByTestName(String testName);

    boolean deleteTest(Long testId);



}
