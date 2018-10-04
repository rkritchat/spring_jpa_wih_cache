package com.example.demospringjap.service;

import com.example.demospringjap.model.Student;
import com.example.demospringjap.repositories.StudentRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Cacheable(value = "studentCache", key="#student.getId()")
    public Student findById(Student student) {
        return studentRepository.findById(student.getId());
    }

    @CacheEvict(value = "studentCache", key = "#student.getId()")
    public String deleteStudent(Student student) {
        studentRepository.removeById(student.getId());
        return "Remove Successfully";
    }

    @CachePut(value = "studentCache", key = "#student.getId()")
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

}
