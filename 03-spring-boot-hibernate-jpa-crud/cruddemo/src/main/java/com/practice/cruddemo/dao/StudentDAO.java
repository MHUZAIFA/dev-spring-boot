package com.practice.cruddemo.dao;

import com.practice.cruddemo.entities.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAO implements IStudentDAO{

    private final EntityManager entityManager;

    @Autowired
    public StudentDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        this.entityManager.persist(student);
    }

    @Override
    public Student getById(int id) {
        return this.entityManager.find(Student.class, id);
    }
}
