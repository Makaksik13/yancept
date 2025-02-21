package com.hakaton.yancept.service.request;

import com.hakaton.yancept.entity.Request;
import com.hakaton.yancept.entity.Student;
import com.hakaton.yancept.entity.Teacher;
import com.hakaton.yancept.exception.NotFoundException;
import com.hakaton.yancept.repository.RequestRepository;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestServiceImpl implements RequestService{
    private final RequestRepository requestRepository;

    @Operation(summary = "Получение всех запросов студента по его id")
    @Override
    public List<Request> getAllByRequesterId(long requesterId) {
        return requestRepository.getAllByStudentId(requesterId);
    }

    @Operation(summary = "Получение всех запросов преподавателя по его id")
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
    public boolean isAcceptedById(long requestId) {
        return requestRepository.isActiveById(requestId)
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
    public Request createRequest(Request request) {
        return requestRepository.save(request);
    }
}
