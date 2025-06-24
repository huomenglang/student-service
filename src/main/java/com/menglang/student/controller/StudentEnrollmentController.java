package com.menglang.student.controller;

import com.menglang.common.library.page.PageResponse;
import com.menglang.common.library.page.PageResponseHandler;
import com.menglang.student.dto.StudentEnrollment.StudentEnrollmentMapper;
import com.menglang.student.dto.StudentEnrollment.StudentEnrollmentRequest;
import com.menglang.student.dto.StudentEnrollment.StudentEnrollmentResponse;
import com.menglang.student.model.entities.StudentEnrollment;
import com.menglang.student.service.studentEnrollment.StudentEnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@RequestMapping("/api/v1/enrollments")
@RestController
public class StudentEnrollmentController {
    private final StudentEnrollmentService studentEnrollmentService;
    private final StudentEnrollmentMapper studentEnrollmentMapper;


    @PostMapping
    public ResponseEntity<PageResponse> create(@RequestBody StudentEnrollmentRequest dto){
        return PageResponseHandler.success(studentEnrollmentService.create(dto),null,"Enrollment Successful");
    }

    @GetMapping("/{id}")
    public ResponseEntity<PageResponse> get(@PathVariable Long id){
        return PageResponseHandler.success(studentEnrollmentService.getById(id),null,"Get Successful");
    }

    @PutMapping("/{id}")
    public ResponseEntity<PageResponse> update(@PathVariable Long id,@RequestBody StudentEnrollmentRequest dto){
        return PageResponseHandler.success(studentEnrollmentService.update(id,dto),null,"Update Successful");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PageResponse> delete(@PathVariable Long id){
        return PageResponseHandler.success(studentEnrollmentService.delete(id),null,"Delete Success");
    }

    @GetMapping("/get-all")
    public ResponseEntity<PageResponse> getAll(@PathVariable Map<String,String> params){
        Page<StudentEnrollment> enrollmentPage=this.studentEnrollmentService.findAll(params);
        List<StudentEnrollmentResponse> enrollmentResponseList= enrollmentPage.getContent().stream().map(studentEnrollmentMapper::toResponse).toList();

        return PageResponseHandler.success(enrollmentResponseList,enrollmentPage,"Get Successful");
    }
}
