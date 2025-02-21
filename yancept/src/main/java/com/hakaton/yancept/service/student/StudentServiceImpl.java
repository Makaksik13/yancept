package com.hakaton.yancept.service.student;

import com.hakaton.yancept.entity.Student;
import com.hakaton.yancept.exception.NotFoundException;
import com.hakaton.yancept.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student getStudentById(long studentId) {
        return studentRepository.findById(studentId).
                orElseThrow(() -> new NotFoundException(String.format("Student with id %s not found", studentId)));
    }
}
