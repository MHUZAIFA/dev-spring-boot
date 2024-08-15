package com.practice.cruddemo.dao;

import com.practice.cruddemo.entities.Student;

import java.util.List;

public interface IStudentDAO {
    void save(Student student);
    Student getById(int id);
    List<Student> getAll();
    List<Student> getByLastname(String lastname);
    void update(Student student);
}
