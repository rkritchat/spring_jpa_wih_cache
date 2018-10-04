package com.example.demospringjap.resource;

import com.example.demospringjap.model.Student;
import com.example.demospringjap.repositories.StudentRepository;
import com.example.demospringjap.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/student")
public class StudentResource {
    private StudentRepository studentRepository;
    private StudentService studentService;

    @Autowired
    public StudentResource(StudentRepository studentRepository, StudentService studentService) {
        this.studentRepository = studentRepository;
        this.studentService = studentService;
    }

    @PostMapping("/id")
    public Student findAll(@RequestBody Student student) {
        return studentService.findById(student);
    }

    @PutMapping
    public String addStudent(@RequestBody Student student) {
        studentRepository.save(student);
        return "Done";
    }

    @DeleteMapping
    public String deleteStudent(@RequestBody Student student) {
        return studentService.deleteStudent(student);
    }

    @PatchMapping
    public Student modifyStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }
}
