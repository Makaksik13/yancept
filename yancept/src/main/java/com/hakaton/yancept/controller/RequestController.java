package com.hakaton.yancept.controller;

import com.hakaton.yancept.entity.Request;
import com.hakaton.yancept.entity.Student;
import com.hakaton.yancept.entity.Teacher;
import com.hakaton.yancept.service.request.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/request")
@RequiredArgsConstructor
public class RequestController {
    private final RequestService requestService;

    @GetMapping
    public List<Request> getAll(){
        return requestService.getAll();
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

    @PostMapping("/create-request")
    public ResponseEntity<String> createRequest(@PathVariable Request request){
        requestService.createRequest(request);
        return ResponseEntity.ok("Request create successfully");
    }
}
