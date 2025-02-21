package com.hakaton.yancept.service.teacher;

import com.hakaton.yancept.entity.Teacher;
import com.hakaton.yancept.exception.NotFoundException;
import com.hakaton.yancept.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService{
    private final TeacherRepository teacherRepository;

    @Override
    public List<Teacher> getAll(){
        return teacherRepository.findAll();
    }

    @Override
    public Teacher findById(long teacherId) {
        return teacherRepository.findById(teacherId)
                .orElseThrow(() -> new NotFoundException(String.format("Teacher with id %s not found", teacherId)));
    }

    @Override
    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }
}
