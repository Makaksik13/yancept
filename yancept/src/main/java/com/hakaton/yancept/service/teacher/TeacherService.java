package com.hakaton.yancept.service.teacher;

import com.hakaton.yancept.entity.Teacher;

import java.util.List;

public interface TeacherService {

    Teacher findById(long teacherId);

    Teacher save(Teacher teacher);

    List<Teacher> getAll();
}
