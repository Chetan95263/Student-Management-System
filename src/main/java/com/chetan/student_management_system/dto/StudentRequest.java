package com.chetan.student_management_system.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StudentRequest {
    @Schema(
            description = "Student full name",
            example = "Sagar"
    )
    @NotBlank(message = "Name is Required!")
    private String name;

    @Schema(
            description = "Student roll no.",
            example = "23242"
    )
    @NotBlank(message = "RollNumber is Required!")
    private String rollNumber;

    @Schema(
            description = "Student marks",
            example = "70"
    )
    @NotNull(message = "Marks is Required!")
    @Min(value = 0, message = "Marks cannot be negative")
    @Max(value = 100, message = "Marks cannot exceed 100")
    private Integer marks;
}
