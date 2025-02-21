package com.hakaton.yancept.service.request;

import com.hakaton.yancept.entity.Request;
import com.hakaton.yancept.entity.Student;
import com.hakaton.yancept.entity.Teacher;
import com.hakaton.yancept.exception.NotFoundException;
import com.hakaton.yancept.repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestServiceImpl implements RequestService{
    private final RequestRepository requestRepository;

    @Override
    public List<Request> getAll() {
        return requestRepository.findAll();
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
        return findById(requestId).getDescription();
    }

    @Override
    public boolean isActiveById(long requestId) {
        return findById(requestId).isActive();
    }

    @Override
    public String getRejectionReasonById(long requestId) {
        return findById(requestId).getRejectionReason();
    }

    @Override
    public LocalDateTime getCreatedAtById(long requestId) {
        return findById(requestId).getCreatedAt();
    }

    @Override
    public Request createRequest(Request request) {
        return requestRepository.save(request);
    }
}
