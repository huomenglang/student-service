package com.menglang.student.controller;
import com.menglang.student.dto.student.StudentRequest;
import com.menglang.student.dto.student.StudentResponse;
import com.menglang.student.service.student.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;


    @GetMapping("/{id}")
    public Optional<StudentResponse> getParentById(@PathVariable Long id){
        return studentService.getById(id);
    }

    @PostMapping
    public StudentResponse createParent(@RequestBody StudentRequest data){
        return studentService.create(data);
    }

    @PutMapping("/{id}")
    public StudentResponse updateParent(@PathVariable Long id, @RequestBody StudentRequest data){
        return studentService.update(id,data);
    }

    @DeleteMapping("/{id}")
    public StudentResponse deleteParent(@PathVariable Long id){
        return studentService.delete(id);
    }}

