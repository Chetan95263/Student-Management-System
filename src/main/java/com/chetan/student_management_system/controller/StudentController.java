package com.chetan.student_management_system.controller;

import com.chetan.student_management_system.dto.StudentRequest;
import com.chetan.student_management_system.model.Student;
import com.chetan.student_management_system.service.StudentService;
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
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.fetchALlStudents());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student = studentService.fetchStudentById(id).orElseThrow(()-> new RuntimeException("Error"));
        return ResponseEntity.ok(student);
    }
    @PostMapping
    public ResponseEntity<String> addStudent(@RequestBody StudentRequest request){
        studentService.addStudent(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("Student Added Successfully!");
    }
}
