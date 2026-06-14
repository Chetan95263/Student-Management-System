package com.chetan.student_management_system.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class StudentResponse {
    private Long id;
    private String name;
    private String rollNumber;
    private Integer marks;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
