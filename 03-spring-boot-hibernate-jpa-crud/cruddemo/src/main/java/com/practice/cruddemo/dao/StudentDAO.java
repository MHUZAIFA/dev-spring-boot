package com.practice.cruddemo.dao;

import com.practice.cruddemo.entities.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public List<Student> getAll() {
        // Note: In JPA Query the Student is the class name NOT the SQL Table name
        // and lastname is the java Student class property and not the SQL column name last_name
        TypedQuery<Student> studentTypedQuery = entityManager.createQuery("from Student order by lastname asc", Student.class);
        return studentTypedQuery.getResultList();
    }

    @Override
    public List<Student> getByLastname(String lastname) {
        TypedQuery<Student> studentTypedQuery =
                this.entityManager.createQuery("from Student where lastname=:searchTerm", Student.class);
        studentTypedQuery.setParameter("searchTerm", lastname);
        return studentTypedQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        this.entityManager.merge(student);

        /*

        TO update multiple records at the same time.

        int numberOfUpdatedRows =
                this.entityManager
                        .createQuery("Update Student set lastname='Tester'", Student.class)
                        .executeUpdate();

         */
    }
}
