package com.chetan.student_management_system.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StudentRequest {
    @NotBlank(message = "Name is Required!")
    private String name;

    @NotBlank(message = "RollNumber is Required!")
    private String rollNumber;

    @NotNull(message = "Marks is Required!")
    @Min(value = 0, message = "Marks cannot be negative")
    @Max(value = 100, message = "Marks cannot exceed 100")
    private Integer marks;
}
