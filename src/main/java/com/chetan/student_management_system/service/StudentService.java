package com.chetan.student_management_system.service;

import com.chetan.student_management_system.dto.StudentRequest;
import com.chetan.student_management_system.dto.StudentResponse;
import com.chetan.student_management_system.exception.ResourceNotFoundException;
import com.chetan.student_management_system.model.Student;
import com.chetan.student_management_system.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.file.ReadOnlyFileSystemException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    public List<StudentResponse> fetchALlStudents(Integer minMarks , Integer maxMarks) {
        List<Student> studentList;
        if(minMarks != null && maxMarks != null) {
            studentList = studentRepository.findByMarksBetween(minMarks , maxMarks);
        } else if(minMarks != null) {
            System.out.println(minMarks);
            studentList = studentRepository.findByMarksGreaterThanEqual(minMarks);
        } else if(maxMarks != null) {
            System.out.println(maxMarks);
            studentList = studentRepository.findByMarksLessThanEqual(maxMarks);
        }
        else {
            studentList = studentRepository.findAll();
        }
        return studentList
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
    public void updateStudent(Long id, StudentRequest updatedStudent) {
        Student student = studentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Student not exists with id: "+id));
        updateStudentFromRequest(student , updatedStudent);
        studentRepository.save(student);
    }
    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Student not exists with id: "+id));
        studentRepository.delete(student);
    }
    private StudentResponse mapToStudentResponse(Student student) {
        return StudentResponse
                .builder()
                .id(student.getId())
                .name(student.getName())
                .rollNumber(student.getRollNumber())
                .marks(student.getMarks())
                .createdAt(student.getCreatedAt())
                .updatedAt(student.getUpdatedAt())
                .build();
    }
    private void updateStudentFromRequest(Student student , StudentRequest request) {
        student.setName(request.getName());
        student.setMarks(request.getMarks());
        student.setRollNumber(request.getRollNumber());
    }

}
