package com.practice.cruddemo.dao;

import com.practice.cruddemo.entities.Student;

public interface IStudentDAO {
    void save(Student student);
    Student getById(int id);
}
