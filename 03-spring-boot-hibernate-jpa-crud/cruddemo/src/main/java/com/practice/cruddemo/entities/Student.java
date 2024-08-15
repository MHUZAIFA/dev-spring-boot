package com.practice.cruddemo.entities;

import jakarta.persistence.*;

@Entity
@Table(name="student")
public class Student {

    // define fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstname;

    @Column(name = "last_name")
    private String lastname;

    @Column(name = "email")
    private String email;

    // define constructors

    public Student() {

    }

    public Student(String firstname, String lastname, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    // define getter/setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    // define toString() method


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    /* Architecture Diagram
    -> DAO (Data Access Object) find, findById, save, update, delete, deleteAll
        DAO needs Entity manager for saving and retrieving entities
    -> Entity manager
        needs data source
        EM and DS are automatically connected by spring boot based on application.properties
        Hence, we can Inject/AutoWire EM into Student DAO
    -> DataSource
    -> Database


    Entity Manager vs JPARepository
    - Use EM:
        1. For low-level control over db and flexibility
        2. To write custom queries
        3. As it provides low-level access to JPA and work directly with JPA entities
        4. Advance DB queries and stored procedures
    - Use JPARepository
        1. Provides CRUD operations out of the box.
        2. Additional features such as pagination and sorting
        3. Can generate queries based on method names
        4. Can create custom queries using @Query

    Note: You can use both (EM and JPARepo) in the same project

     */
}
