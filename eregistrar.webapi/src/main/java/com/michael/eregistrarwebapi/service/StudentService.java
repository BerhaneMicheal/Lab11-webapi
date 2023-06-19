package com.michael.eregistrarwebapi.service;

import com.michael.eregistrarwebapi.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student create(Student student);
    Student update(Student student);
    void delete(Integer studentId);
    List<Student> getAll();
    Optional<Student> get(Integer studentId);
    List<Student> searchStudents(String param);
}
