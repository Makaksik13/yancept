package com.hakaton.yancept.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name", length = 64, nullable = false)
    private String firstName;

    @Column(name = "second_name", length = 64, nullable = false)
    private String secondName;

    @Column(name = "patronymic", length = 64, nullable = false)
    private String patronymic;

    @Column(name = "about_me", length = 4096)
    private String description;

    @Column(name = "mentor_id")
    private Long mentorId;

    @OneToMany(mappedBy = "student")
    private List<Request> requests;


}
