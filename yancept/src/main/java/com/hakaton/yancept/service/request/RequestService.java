package com.hakaton.yancept.service.request;

import com.hakaton.yancept.entity.Request;
import com.hakaton.yancept.entity.Student;
import com.hakaton.yancept.entity.Teacher;

import java.time.LocalDateTime;
import java.util.List;

public interface RequestService {
    List<Request> getAllByRequesterId(long requesterId);

    List<Request> getAllByReceiverId(long receiverId);

    Request findById(long requestId);

    Student getStudentById(long requestId);

    Teacher getTeacherById(long requestId);

    String getDescriptionById(long requestId);

    String getRejectionReasonById(long requestId);

    LocalDateTime getCreatedAtById(long requestId);

    Request createRequest(Request request);

    Request approveRequest(long requestId);

    Request rejectRequest(long requestId, String rejectMessage);
}
