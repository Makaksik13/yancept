// package com.hakaton.yancept.entity;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;
// import lombok.Data;

// @Data
// @Entity
// @Table(name = "student")
// public class Student {
//     @Id
//     @Column(name = "id")
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private long id;

//     @Column(name = "firstName", nullable = false)
//     private String firstName;

//     @Column(name = "lastName", nullable = false)
//     private String lastName;

//     @Column(name = "patronymic", nullable = false)
//     private String patronymic;

//     @Column(name = "year", nullable = false)
//     private long yaer;

//     @Column(name = "speciality", nullable = false)
//     private String speciality;

//     @Column(name = "group")
//     private long group;

//     @Column(name = "selectedTeacher", nullable = true)
//     private Teacher selectedTeacher;
// }
