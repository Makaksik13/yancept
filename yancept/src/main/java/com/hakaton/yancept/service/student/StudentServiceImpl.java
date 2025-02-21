package com.hakaton.yancept.service.student;

import com.hakaton.yancept.entity.Student;
import com.hakaton.yancept.exception.NotFoundException;
import com.hakaton.yancept.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public Student getStudentById(long studentId) {
        return studentRepository.findById(studentId).
                orElseThrow(() -> new NotFoundException(String.format("Student with id %s not found", studentId)));
    }
    @Override
    public Student save(Student student){
        return  studentRepository.save(student);
    }

    @Override
    public List<Student> getAllAcceptedStudentsByMentorId(long mentorId) {
        return studentRepository.getStudentsByMentorId(mentorId);
    }

    @Override
    public List<Student> findAllByIds(List<Long> ids) {
        return studentRepository.findAllById(ids);
    }
}
