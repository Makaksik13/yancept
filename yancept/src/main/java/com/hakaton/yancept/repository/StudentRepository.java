package com.hakaton.yancept.repository;

import com.hakaton.yancept.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface StudentRepository extends JpaRepository<Student, Long> {

}
