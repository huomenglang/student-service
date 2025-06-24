package com.menglang.student.controller;
import com.menglang.common.library.page.PageResponse;
import com.menglang.common.library.page.PageResponseHandler;
import com.menglang.student.dto.student.StudentMapper;
import com.menglang.student.dto.student.StudentRequest;
import com.menglang.student.dto.student.StudentResponse;
import com.menglang.student.model.entities.Student;
import com.menglang.student.service.student.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    private final StudentMapper studentMapper;

    @GetMapping("/{id}")
    public ResponseEntity<PageResponse> getParentById(@PathVariable Long id){
        return PageResponseHandler.success(studentService.getById(id),null,"Get Successful");
    }

    @PostMapping
    public ResponseEntity<PageResponse> createParent(@RequestBody StudentRequest data){
        return PageResponseHandler.success(studentService.create(data),null,"Create Successful.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<PageResponse> updateParent(@PathVariable Long id, @RequestBody StudentRequest data){
        return PageResponseHandler.success(studentService.update(id,data),null,"Update Successful");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PageResponse> deleteParent(@PathVariable Long id){
        return PageResponseHandler.success(studentService.delete(id),null,"Delete Successful");
    }

    @GetMapping("/get-all")
    public ResponseEntity<PageResponse> getAll(@PathVariable Map<String,String> params){
        Page<Student> studentPage=studentService.getAll(params);
        List<StudentResponse> studentResponses=studentPage.getContent().stream().map(studentMapper::studentResponse).toList();
        return PageResponseHandler.success(studentResponses,studentPage,"Get Successful.");
    }
}

