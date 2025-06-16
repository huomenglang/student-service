package com.menglang.student.controller;

import com.menglang.student.dto.StudentEnrollment.StudentEnrollmentRequest;
import com.menglang.student.dto.StudentEnrollment.StudentEnrollmentResponse;
import com.menglang.student.service.studentEnrollment.StudentEnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@RequestMapping("/api/v1/enrollments")
@RestController
public class StudentEnrollmentController {
    private final StudentEnrollmentService studentEnrollmentService;


    @PostMapping
    public StudentEnrollmentResponse create(@RequestBody StudentEnrollmentRequest dto){
        return studentEnrollmentService.create(dto);
    }

    @GetMapping("/{id}")
    public Optional<StudentEnrollmentResponse> create(@PathVariable Long id){
        return studentEnrollmentService.getById(id);
    }

    @PutMapping("/{id}")
    public StudentEnrollmentResponse update(@PathVariable Long id,@RequestBody StudentEnrollmentRequest dto){
        return studentEnrollmentService.update(id,dto);
    }

    @DeleteMapping("/{id}")
    public StudentEnrollmentResponse delete(@PathVariable Long id){
        return studentEnrollmentService.delete(id);
    }
}
