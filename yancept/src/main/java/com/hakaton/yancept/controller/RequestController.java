package com.hakaton.yancept.controller;

import com.hakaton.yancept.entity.Request;
import com.hakaton.yancept.entity.Student;
import com.hakaton.yancept.entity.Teacher;
import com.hakaton.yancept.service.request.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/request")
@RequiredArgsConstructor
public class RequestController {
    private final RequestService requestService;

    @GetMapping("/requester/{id}")
    public List<Request> getAllByRequesterId(@PathVariable Long id){
        return requestService.getAllByRequesterId(id);
    }

    @GetMapping("/receiver/{id}")
    public List<Request> getAllByReceiverId(@PathVariable Long id){
        return requestService.getAllByReceiverId(id);
    }

    @GetMapping("/{id}")
    public Request getRequestById(@PathVariable Long id){
        return requestService.findById(id);
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable Long id){
        return requestService.getStudentById(id);
    }

    @GetMapping("/teacher/{id}")
    public Teacher getTeacherById(@PathVariable Long id){
        return requestService.getTeacherById(id);
    }

    @GetMapping("active/{id}")
    public boolean isActiveById(@PathVariable Long id){
        return requestService.isActiveById(id);
    }

    @GetMapping("/reaction/{id}")
    public String getRejectionReasonById(@PathVariable Long id){
        return requestService.getRejectionReasonById(id);
    }

    @GetMapping("/createdAt/{id}")
    public LocalDateTime getCreatedAt(@PathVariable Long id){
        return requestService.getCreatedAtById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Request createRequest(@PathVariable Request request){
        return requestService.createRequest(request);
    }
}
