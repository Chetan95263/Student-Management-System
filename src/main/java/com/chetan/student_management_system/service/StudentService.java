package com.chetan.student_management_system.service;

import com.chetan.student_management_system.dto.StudentRequest;
import com.chetan.student_management_system.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private List<Student> studentList = new ArrayList<>();
    public List<Student> fetchALlStudents() {
        return studentList;
    }
    public Optional<Student> fetchStudentById(Long id) {
        return studentList
                .stream()
                .filter(student -> id.equals(student.getId()))
                .findFirst();
    }

    public void addStudent(StudentRequest request) {
        studentList.add(
                Student.builder()
                .id(request.getId())
                .name(request.getName())
                .rollNumber(request.getRollNumber())
                .marks(request.getMarks())
                .build()
        );
    }
}
