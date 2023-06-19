package com.michael.eregistrarwebapi.controller;

import com.michael.eregistrarwebapi.dtos.ApiResponse;
import com.michael.eregistrarwebapi.model.Student;
import com.michael.eregistrarwebapi.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/eregistrar/api/student", "/eregistrar/api/student/"})
public class StudentsController {
    private StudentService studentService;

    public StudentsController(StudentService studentService) {
        this.studentService = studentService;
    }
//    @GetMapping("list")
    @GetMapping({"list"})
    public ResponseEntity<ApiResponse<List<Student>>> getAll() {
        var students = studentService.getAll();
        return ResponseEntity.ok(
                    new ApiResponse<>("Success", students)
        );
    }

    @GetMapping({"get/{studentId}"})
    public ResponseEntity<ApiResponse<?>> getById(@PathVariable Integer studentId) {
        var optStudent = studentService.get(studentId);
        if (optStudent.isPresent()) {
            return ResponseEntity.ok(
                    new ApiResponse<>("Success", optStudent.get())
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ApiResponse<Student>("Student not found", null)
            );
        }
    }

    @PostMapping("register")
    public ResponseEntity<ApiResponse<Student>> create(@Valid @RequestBody Student student) {
        var savedStudent = studentService.create(student);
        return ResponseEntity.ok(new ApiResponse<>("created successfully", savedStudent));
    }

    @PutMapping("update/{studentId}")
    public ResponseEntity<ApiResponse<Student>> update(@PathVariable Integer studentId, @Valid @RequestBody Student student) {
        var optStudent = studentService.get(studentId);
        if (optStudent.isPresent()) {
            student.setStudentId(studentId);
            var updatedStudent = studentService.update(student);
            return ResponseEntity.ok(new ApiResponse<>("Updated successfully", updatedStudent));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ApiResponse<Student>("Student not found", null)
            );
        }
    }

    @DeleteMapping("delete/{studentId}")
    public ResponseEntity<ApiResponse<?>> delete(@PathVariable Integer studentId) {
        var optStudent = studentService.get(studentId);
        if (optStudent.isPresent()) {
            studentService.delete(studentId);
            return ResponseEntity.ok(new ApiResponse<>("Deleted successfully"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ApiResponse<Student>("Student not found", null)
            );
        }
    }
}