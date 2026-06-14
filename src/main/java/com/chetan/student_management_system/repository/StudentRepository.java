package com.chetan.student_management_system.repository;

import com.chetan.student_management_system.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student , Long> {
    List<Student> findByMarksBetween(Integer minMarks, Integer maxMarks);

    List<Student> findByMarksLessThanEqual(Integer maxMarks);

    List<Student> findByMarksGreaterThanEqual(Integer minMarks);
}
