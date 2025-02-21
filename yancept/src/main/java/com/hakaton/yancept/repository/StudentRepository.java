package com.hakaton.yancept.repository;

import com.hakaton.yancept.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> getStudentsByMentorId(long mentorId);
}
