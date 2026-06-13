package com.chetan.student_management_system.controller;

import com.chetan.student_management_system.dto.StudentRequest;
import com.chetan.student_management_system.dto.StudentResponse;
import com.chetan.student_management_system.service.StudentService;
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

    @GetMapping
    public ResponseEntity<List<StudentResponse>> getAllStudents() {
        return ResponseEntity.ok(studentService.fetchALlStudents());
    }
    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> getStudentById(@PathVariable Long id) {
        return studentService.fetchStudentById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<String> addStudent(@Valid @RequestBody StudentRequest request){
        studentService.addStudent(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("Student Added Successfully!");
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable Long id ,
                                                @Valid @RequestBody StudentRequest updatedStudent) {
        studentService.updateStudent(id , updatedStudent);
        return ResponseEntity.ok("Student updated Successfully!");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

}
