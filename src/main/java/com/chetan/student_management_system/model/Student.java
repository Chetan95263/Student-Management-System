package com.chetan.student_management_system.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Student {
    private Long id;
    private String name;
    private String rollNumber;
    private Integer marks;
}
