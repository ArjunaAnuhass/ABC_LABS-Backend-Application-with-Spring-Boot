package com.aaCode.ABC_backend.dto;

import com.aaCode.ABC_backend.modal.Technician;
import com.aaCode.ABC_backend.modal.Test;
import lombok.Data;

@Data
public class TestRequest {

    private Long testId;
    private String testName;
    private String description;
    private Long price;
    private Long cateId;
//    private String technicianName;



}
