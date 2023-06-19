package com.michael.eregistrarwebapi.service.impl;

import com.michael.eregistrarwebapi.model.Student;
import com.michael.eregistrarwebapi.repository.StudentRepository;
import com.michael.eregistrarwebapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Student create(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student update(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void delete(Integer studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> get(Integer studentId) {
        return studentRepository.findById(studentId);
    }

    @Override
    public List<Student> searchStudents(String param) {
        return studentRepository.searchStudents(param);
    }

//    @Override
//    public List<Student> searchStudents(String param) {
//        return studentRepository.findAllByStudentNumberContainingIgnoreCaseOrFirstNameContainingIgnoreCaseOrMiddleNameContainingOrLastNameContainingOrIsInternationalContainingIgnoreCase(param, param, param, param, param);
//    }


}
