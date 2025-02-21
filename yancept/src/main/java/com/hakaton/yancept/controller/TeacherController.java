package com.hakaton.yancept.controller;

import com.hakaton.yancept.entity.Teacher;
import com.hakaton.yancept.service.teacher.TeacherService;
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

    @GetMapping()
    public List<Teacher> getAll(){
        return teacherService.getAll();
    }

    @GetMapping("/link/{id}")
    public String getLinkById(@PathVariable Long id){
        return teacherService.getTeacherLinkById(id);
    }

    @GetMapping("/{id}")
    public Teacher getTeacherById(@PathVariable Long id){
        return teacherService.findById(id);
    }
}
