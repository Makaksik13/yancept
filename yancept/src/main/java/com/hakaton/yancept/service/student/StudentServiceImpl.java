package com.hakaton.yancept.service.student;

import com.hakaton.yancept.entity.Student;
import com.hakaton.yancept.exception.NotFoundException;
import com.hakaton.yancept.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public Student getStudentById(long studentId) {
        return studentRepository.findById(studentId).
                orElseThrow(() -> new NotFoundException(String.format("Student with id %s not found", studentId)));
    }
}
