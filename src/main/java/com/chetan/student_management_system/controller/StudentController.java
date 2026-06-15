package com.chetan.student_management_system.controller;

import com.chetan.student_management_system.dto.StudentRequest;
import com.chetan.student_management_system.dto.StudentResponse;
import com.chetan.student_management_system.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(("/api/students"))
public class StudentController {
    private final StudentService studentService;

    @Operation(summary = "Get all students or filter students by marks range")
    @GetMapping
    public ResponseEntity<List<StudentResponse>> getAllStudents(
            @Parameter(description = "Minimum marks")
            @RequestParam(required = false) Integer minMarks ,
            @Parameter(description = "Maximum marks")
            @RequestParam(required = false) Integer maxMarks
    ) {
        return ResponseEntity.ok(studentService.fetchALlStudents(minMarks , maxMarks));
    }
    @Operation(summary = "Get student by ID")
    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> getStudentById(
            @Parameter(description = "Unique student ID")
            @PathVariable Long id) {
        return studentService.fetchStudentById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Create a new student")
    @PostMapping
    public ResponseEntity<String> addStudent(@Valid @RequestBody StudentRequest request){
        studentService.addStudent(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("Student Added Successfully!");
    }

    @Operation(summary = "update student by ID")
    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(
            @Parameter(description = "Unique student ID")
            @PathVariable Long id ,
            @Valid @RequestBody StudentRequest updatedStudent) {
        studentService.updateStudent(id , updatedStudent);
        return ResponseEntity.ok("Student updated Successfully!");
    }

    @Operation(summary = "delete student by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(
            @Parameter(description = "Unique student ID")
            @PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

}
