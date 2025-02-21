package com.hakaton.yancept.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name", length = 64, nullable = false)
    private String firstName;

    @Column(name = "second_name", length = 64, nullable = false)
    private String secondName;

    @Column(name = "patronymic", length = 64, nullable = false)
    private String patronymic;

    @Column(name = "link_to_profile", length = 64, nullable = false)
    private String linkToProfile;

    @Column(name = "about_me", length = 4096)
    private String description;
}
