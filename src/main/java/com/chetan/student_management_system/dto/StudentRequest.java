package com.chetan.student_management_system.dto;

import lombok.Data;

@Data
public class StudentRequest {
    private Long id;
    private String name;
    private String rollNumber;
    private Integer marks;
}
