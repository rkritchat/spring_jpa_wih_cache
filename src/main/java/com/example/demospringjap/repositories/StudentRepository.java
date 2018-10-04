package com.example.demospringjap.repositories;

import com.example.demospringjap.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    Student findByFirstNameAndLastName(String firstName, String lastName);

    Student findById(int id);


    @Transactional
    void removeById(int id);
}
