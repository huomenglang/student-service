package com.menglang.student.controller;

import com.menglang.student.dto.studentStatus.StudentStatusRequest;
import com.menglang.student.dto.studentStatus.StudentStatusResponse;
import com.menglang.student.service.studentStatus.StudentYearlyStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api/v1/studentStatus")
@RestController
@RequiredArgsConstructor
public class StudentStatusController {
    private final StudentYearlyStatusService studentYearlyStatusService;

    @PostMapping
    public ResponseEntity<StudentStatusResponse> create(@RequestBody StudentStatusRequest dto){
        return ResponseEntity.ok(studentYearlyStatusService.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<StudentStatusResponse>> getById(@PathVariable Long id){
        return ResponseEntity.ok(studentYearlyStatusService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentStatusResponse> update(@PathVariable Long id,@RequestBody StudentStatusRequest dto){
        return ResponseEntity.ok(studentYearlyStatusService.update(id,dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StudentStatusResponse> delete(@PathVariable Long id){
        return ResponseEntity.ok(studentYearlyStatusService.delete(id));
    }
}
