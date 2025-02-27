package com.hakaton.yancept.service.request;

import com.hakaton.yancept.entity.Request;
import com.hakaton.yancept.entity.Status;
import com.hakaton.yancept.entity.Student;
import com.hakaton.yancept.entity.Teacher;
import com.hakaton.yancept.exception.NotFoundException;
import com.hakaton.yancept.repository.RequestRepository;
import com.hakaton.yancept.service.student.StudentService;
import com.hakaton.yancept.service.teacher.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestServiceImpl implements RequestService{
    private final RequestRepository requestRepository;
    private final StudentService studentService;
    private  final TeacherService teacherService;

    @Override
    public List<Request> getAllByRequesterId(long requesterId) {
        return requestRepository.getAllByStudentId(requesterId);
    }

    @Override
    public List<Request> getAllByReceiverId(long receiverId) {
        return requestRepository.getAllByTeacherId(receiverId);
    }

    @Override
    public Request findById(long requestId) {
        return requestRepository.findById(requestId).orElseThrow(
                () -> new NotFoundException(String.format("Request with id %s not found", requestId)));
    }

    @Override
    public Student getStudentById(long requestId) {
        return findById(requestId).getStudent();
    }

    @Override
    public Teacher getTeacherById(long requestId) {
        return findById(requestId).getTeacher();
    }

    @Override
    public String getDescriptionById(long requestId) {
        return requestRepository.getDescriptionById(requestId)
                .orElseThrow(() -> new NotFoundException(String.format("Request with id %s not found", requestId)));
    }

    @Override
    public String getRejectionReasonById(long requestId) {
        return requestRepository.getRejectionReasonById(requestId)
                .orElseThrow(() -> new NotFoundException(String.format("Request with id %s not found", requestId)));
    }

    @Override
    public LocalDateTime getCreatedAtById(long requestId) {
        return requestRepository.getCreatedAtById(requestId)
                .orElseThrow(() -> new NotFoundException(String.format("Request with id %s not found", requestId)));
    }

    @Override
    public Request createRequest(long teacherId, long studentId, String desc) {
        Request newRequest = new Request();
        newRequest.setDescription(desc);

        Student student = studentService.getStudentById(studentId);

        Teacher teacher = teacherService.findById(teacherId);

        newRequest.setStudent(student);
        newRequest.setTeacher(teacher);
        newRequest.setStatus(Status.IN_PROCESS);

        return requestRepository.save(newRequest);
    }

    @Override
    public Request approveRequest(long requestId) {
        Request approveRequest = findById(requestId);

        Student approveStudent = approveRequest.getStudent();
        approveStudent.setMentorId(approveRequest.getTeacher().getId());
        studentService.save(approveStudent);

        approveRequest.setStatus(Status.ACCEPTED);
        return requestRepository.save(approveRequest);
    }

    @Override
    public Request rejectRequest(long requestId, String rejectMessage) {
        Request rejectRequest = findById(requestId);
        rejectRequest.setStatus(Status.REJECT);
        rejectRequest.setRejectionReason(rejectMessage);
        return requestRepository.save(rejectRequest);
    }

    @Override
    public void deleteRequest(long requestId) {
        requestRepository.deleteById(requestId);
    }

    @Override
    public List<Student> getAllStudentsInProcessByTeacherId(long teacherId) {
        List<Long> studentsInProcessId = requestRepository.getStudentIdsByTeacherIdAndStatus(teacherId, Status.IN_PROCESS);
        return studentService.findAllByIds(studentsInProcessId);
    }

}
