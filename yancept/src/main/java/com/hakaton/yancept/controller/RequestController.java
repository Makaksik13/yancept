package com.hakaton.yancept.controller;

import com.hakaton.yancept.entity.Request;
import com.hakaton.yancept.entity.Status;
import com.hakaton.yancept.entity.Student;
import com.hakaton.yancept.entity.Teacher;
import com.hakaton.yancept.service.request.RequestService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/request")
@RequiredArgsConstructor
public class RequestController {
    private final RequestService requestService;

    @Operation(summary = "получить список заявок по id студента")
    @GetMapping("/requester/{id}")
    public List<Request> getAllByRequesterId(@PathVariable Long id){
        return requestService.getAllByRequesterId(id);
    }

    @Operation(summary = "получение списка заявок по id преподавателя")
    @GetMapping("/receiver/{id}")
    public List<Request> getAllByReceiverId(@PathVariable Long id){
        return requestService.getAllByReceiverId(id);
    }

    @GetMapping("/{id}")
    @Operation(summary = "получить заявку по id")
    public Request getRequestById(@PathVariable Long id){
        return requestService.findById(id);
    }

    @GetMapping("/student/{id}")
    @Operation(summary = "получить студента по id заявки")
    public Student getStudentById(@PathVariable Long id){
        return requestService.getStudentById(id);
    }

    @GetMapping("/teacher/{id}")
    @Operation(summary = "получить преподавателя по id заявки")
    public Teacher getTeacherById(@PathVariable Long id){
        return requestService.getTeacherById(id);
    }

    @GetMapping("/reaction/{id}")
    @Operation(summary = "получить причину отказа по id")
    public String getRejectionReasonById(@PathVariable Long id){
        return requestService.getRejectionReasonById(id);
    }

    @GetMapping("/createdAt/{id}")
    @Operation(summary = "получить время подачи заявки по id")
    public LocalDateTime getCreatedAt(@PathVariable Long id){
        return requestService.getCreatedAtById(id);
    }

    @PostMapping("/student/{studentId}/teacher/{teacherId}")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "создание заявки у студента с studentId и преподавателя с teacherId")
    public Request createRequest(@RequestBody String desc, @PathVariable Long studentId, @PathVariable Long teacherId){
        return requestService.createRequest(teacherId, studentId, desc);
    }

    @PutMapping("/accept/{id}")
    @Operation(summary = "подтверждение заявки преподавателем")
    public Request approveRequest(@PathVariable Long id){
        return requestService.approveRequest(id);
    }

    @PutMapping("/reject/{id}")
    @Operation(summary = "отклонение заявки преподавателем")
    public Request rejectRequest(@RequestBody(required = false) String message, @PathVariable Long id){
        return requestService.rejectRequest(id, message);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "удаление заявки по id")
    public String deleteRequest(@PathVariable Long id){
        if(requestService.findById(id).getStatus() == Status.ACCEPTED){
            return "Accepted request cannot be deleted";
        }
        requestService.deleteRequest(id);
        return "Delete successfully";
    }
}
