package com.chetan.student_management_system.service;

import com.chetan.student_management_system.dto.StudentRequest;
import com.chetan.student_management_system.dto.StudentResponse;
import com.chetan.student_management_system.model.Student;
import com.chetan.student_management_system.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    public List<StudentResponse> fetchALlStudents() {
        return studentRepository.findAll()
                .stream()
                .map(this::mapToStudentResponse)
                .collect(Collectors.toList());
    }
    public Optional<StudentResponse> fetchStudentById(Long id) {
        return studentRepository.findById(id)
                .map(this::mapToStudentResponse);
    }
    public void addStudent(StudentRequest request) {
        Student student = new Student();
        updateStudentFromRequest(student , request);
        studentRepository.save(student);
    }
    private StudentResponse mapToStudentResponse(Student student) {
        return StudentResponse
                .builder()
                .id(student.getId())
                .name(student.getName())
                .rollNumber(student.getRollNumber())
                .marks(student.getMarks())
                .build();
    }
    private void updateStudentFromRequest(Student student , StudentRequest request) {
        student.setName(request.getName());
        student.setMarks(request.getMarks());
        student.setRollNumber(request.getRollNumber());
    }
}
