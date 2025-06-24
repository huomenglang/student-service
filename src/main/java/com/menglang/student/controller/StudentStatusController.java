package com.menglang.student.controller;

import com.menglang.common.library.page.PageResponse;
import com.menglang.common.library.page.PageResponseHandler;
import com.menglang.student.dto.StudentEnrollment.StudentEnrollmentResponse;
import com.menglang.student.dto.studentStatus.StudentStatusMapper;
import com.menglang.student.dto.studentStatus.StudentStatusRequest;
import com.menglang.student.dto.studentStatus.StudentStatusResponse;
import com.menglang.student.model.entities.StudentEnrollment;
import com.menglang.student.model.entities.StudentYearlyStatus;
import com.menglang.student.service.studentStatus.StudentYearlyStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequestMapping("/api/v1/studentStatus")
@RestController
@RequiredArgsConstructor
public class StudentStatusController {
    private final StudentYearlyStatusService studentYearlyStatusService;
    private final StudentStatusMapper mapper;

    @PostMapping
    public ResponseEntity<PageResponse> create(@RequestBody StudentStatusRequest dto){
        return PageResponseHandler.success(studentYearlyStatusService.create(dto),null,"Create Success");
    }

    @GetMapping("/{id}")
    public ResponseEntity<PageResponse> getById(@PathVariable Long id){
        return PageResponseHandler.success(studentYearlyStatusService.getById(id),null,"Get Success");
    }

    @PutMapping("/{id}")
    public ResponseEntity<PageResponse> update(@PathVariable Long id,@RequestBody StudentStatusRequest dto){
        return PageResponseHandler.success(studentYearlyStatusService.update(id,dto),null,"Update Success");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PageResponse> delete(@PathVariable Long id){
        return PageResponseHandler.success(studentYearlyStatusService.delete(id),null,"Delete Success");
    }

    @GetMapping("/get-all")
    public ResponseEntity<PageResponse> getAll(@PathVariable Map<String,String> params){
        Page<StudentYearlyStatus> studentYearlyStatusPage=this.studentYearlyStatusService.findAll(params);
        List<StudentStatusResponse> studentStatusResponseList= studentYearlyStatusPage.getContent().stream().map(mapper::toResponse).toList();
        return PageResponseHandler.success(studentStatusResponseList,studentYearlyStatusPage,"Get Successful");
    }
}
