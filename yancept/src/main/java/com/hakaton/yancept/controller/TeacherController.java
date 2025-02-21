package com.hakaton.yancept.controller;

import com.hakaton.yancept.entity.Teacher;
import com.hakaton.yancept.service.teacher.TeacherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @Operation(summary = "Получение списка всех преподавателей")
    @GetMapping()
    public List<Teacher> getAll(){
        return teacherService.getAll();
    }

    @GetMapping("/link/{id}")
    @Operation(summary = "Получение ссылки на преподавателя по его id")
    public String getLinkById(
            @Parameter(description = "Идентификатор преподавателя", required = true, example = "1")
            @PathVariable Long id){
        return teacherService.getTeacherLinkById(id);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получение преподавателя по его id")
    public Teacher getTeacherById(
            @Parameter(description = "Идентификатор преподавателя", required = true, example = "1")
            @PathVariable Long id){
        return teacherService.findById(id);
    }
}
