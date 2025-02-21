package com.hakaton.yancept.controller;

import com.hakaton.yancept.entity.Student;
import com.hakaton.yancept.service.student.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    @Operation(summary = "Получение студентов по id")
    @GetMapping("/{id}")
    public Student getStudentById(
            @Parameter(description = "Идентификатор студента", required = true, example = "1")
            @PathVariable Long id
    ){
        return studentService.getStudentById(id);
    }

    @GetMapping("/accepted/teacher/{id}")
    @Operation(summary = "Получение всех принятых студентов по id преподавателя")
    public List<Student> getAllAcceptedStudentsByMentorId(
            @Parameter(description = "Идентификатор преподавателя", required = true, example = "1")
            @PathVariable Long id
    ){
        return studentService.getAllAcceptedStudentsByMentorId(id);
    }
}
