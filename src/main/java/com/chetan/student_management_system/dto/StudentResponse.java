package com.chetan.student_management_system.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentResponse {
    private Long id;
    private String name;
    private String rollNumber;
    private Integer marks;
}
