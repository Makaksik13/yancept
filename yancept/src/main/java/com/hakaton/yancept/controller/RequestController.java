package com.hakaton.yancept.controller;

import com.hakaton.yancept.entity.Request;
import com.hakaton.yancept.entity.Status;
import com.hakaton.yancept.entity.Student;
import com.hakaton.yancept.entity.Teacher;
import com.hakaton.yancept.service.request.RequestService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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

    @Operation(summary = "Получить список заявок по id студента")
    @GetMapping("/requester/{id}")
    public List<Request> getAllByRequesterId(
            @Parameter(description = "Идентификатор студента", required = true, example = "1")
            @PathVariable Long id
    ){
        return requestService.getAllByRequesterId(id);
    }

    @Operation(summary = "Получение списка заявок по id преподавателя")
    @GetMapping("/receiver/{id}")
    public List<Request> getAllByReceiverId(
            @Parameter(description = "Идентификатор преподавателя", required = true, example = "1")
            @PathVariable Long id
    ){
        return requestService.getAllByReceiverId(id);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить заявку по её id")
    public Request getRequestById(
            @Parameter(description = "Идентификатор заявки", required = true, example = "1")
            @PathVariable Long id
    ){
        return requestService.findById(id);
    }

    @GetMapping("/student/{id}")
    @Operation(summary = "Получить студента по id заявки")
    public Student getStudentById(
            @Parameter(description = "Идентификатор заявки", required = true, example = "1")
            @PathVariable Long id
    ){
        return requestService.getStudentById(id);
    }

    @GetMapping("/teacher/{id}")
    @Operation(summary = "Получить преподавателя по id заявки")
    public Teacher getTeacherById(
            @Parameter(description = "Идентификатор заявки", required = true, example = "1")
            @PathVariable Long id
    ){
        return requestService.getTeacherById(id);
    }

    @GetMapping("/reaction/{id}")
    @Operation(summary = "Получить причину отказа по id заявки")
    public String getRejectionReasonById(
            @Parameter(description = "Идентификатор заявки", required = true, example = "1")
            @PathVariable Long id
    ){
        return requestService.getRejectionReasonById(id);
    }

    @GetMapping("/createdAt/{id}")
    @Operation(summary = "Получить время подачи заявки по id заявки")
    public LocalDateTime getCreatedAt(
            @Parameter(description = "Идентификатор заявки", required = true, example = "1")
            @PathVariable Long id
    ){
        return requestService.getCreatedAtById(id);
    }

    @PostMapping("/student/{studentId}/teacher/{teacherId}")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Создание заявки у студента с studentId и преподавателя с teacherId")
    public Request createRequest(@RequestBody String desc,
                                 @Parameter(description = "Идентификатор студента", required = true, example = "1")
                                 @PathVariable Long studentId,
                                 @Parameter(description = "Идентификатор преподавателя", required = true, example = "1")
                                 @PathVariable Long teacherId)
    {
        return requestService.createRequest(teacherId, studentId, desc);
    }

    @PutMapping("/accept/{id}")
    @Operation(summary = "Подтверждение заявки преподавателем")
    public Request approveRequest(
            @Parameter(description = "Идентификатор заявки", required = true, example = "1")
            @PathVariable Long id
    ){
        return requestService.approveRequest(id);
    }

    @PutMapping("/reject/{id}")
    @Operation(summary = "Отклонение заявки преподавателем")
    public Request rejectRequest(@RequestBody(required = false) String message,
                                 @Parameter(description = "Идентификатор заявки", required = true, example = "1")
                                 @PathVariable Long id){
        return requestService.rejectRequest(id, message);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удаление заявки по id")
    public String deleteRequest(
            @Parameter(description = "Идентификатор заявки", required = true, example = "1")
            @PathVariable Long id
    ){
        if(requestService.findById(id).getStatus() == Status.ACCEPTED){
            return "Accepted request cannot be deleted";
        }
        requestService.deleteRequest(id);
        return "Delete successfully";
    }

    @GetMapping("/in-process/teacher/{id}")
    @Operation(summary = "Получение всех ожидающих студентов по id преподавателя")
    public List<Student> getAllStudentsInProcessByTeacherId(
            @Parameter(description = "Идентификатор преподавателя", required = true, example = "1")
            @PathVariable Long id
    ){
        return requestService.getAllStudentsInProcessByTeacherId(id);
    }
}
