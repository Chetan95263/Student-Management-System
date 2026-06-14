package com.chetan.student_management_system.config;

import com.chetan.student_management_system.model.Student;
import com.chetan.student_management_system.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {
    private final StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
//        addStudent();
    }
    private void addStudent() {
        List<Student> students = List.of(
                new Student(null,"Chetan", "101", 85,null , null),
                new Student(null, "Rahul", "102", 45 , null , null),
                new Student(null, "Priya", "103", 92 , null , null),
                new Student(null, "Aman", "104", 67 , null , null),
                new Student(null, "Riya", "105", 30 , null , null),
                new Student(null, "Karan", "106", 78 , null , null),
                new Student(null, "Sneha", "107", 59 , null , null),
                new Student(null, "Arjun", "108", 99 , null , null)
        );

        studentRepository.saveAll(students);
    }
}
