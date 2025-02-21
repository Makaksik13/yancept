package com.hakaton.yancept.service.student;

import com.hakaton.yancept.entity.Student;
import com.hakaton.yancept.entity.Teacher;

import java.util.List;

public interface StudentService {
    Student getStudentById(long studentId);

    Student save(Student student);
}
