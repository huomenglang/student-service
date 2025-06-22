package com.menglang.student.controller;

import com.menglang.common.library.dateFormat.DateUtils;
import com.menglang.common.library.page.PageResponse;
import com.menglang.common.library.page.PageResponseHandler;
import com.menglang.student.dto.academicYear.AcademicYearRequest;
import com.menglang.student.dto.academicYear.AcademicYearResponse;
import com.menglang.student.service.AcademicYear.AcademicService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hibernate.type.descriptor.DateTimeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/academics")
@RestController
@RequiredArgsConstructor
public class AcademicYearController {
    private static final Logger log = LoggerFactory.getLogger(AcademicYearController.class);
    private final AcademicService academicService;


    @PostMapping
    public ResponseEntity<PageResponse> addAcademicYear(@Valid @RequestBody AcademicYearRequest academicYear) {
        log.info("Invoke post....");
        return PageResponseHandler.success(academicService.createAcademicYear(academicYear),null,"create successful");
    }

    @GetMapping("/{id}")
    public ResponseEntity<PageResponse> getAcademicYearById(@PathVariable Long id) {
        log.info(" acadamic id : {} ",id);
        return PageResponseHandler.success(academicService.getAcademicYear(id),null,"get successful");
    }

    @PutMapping("/{id}")
    public ResponseEntity<PageResponse> updateAcademicYear(@PathVariable Long id, @RequestBody AcademicYearRequest academicYear) {
        return PageResponseHandler.success(academicService.updateAcademicYear(academicYear, id),null,"Update Successful");
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<AcademicYearResponse>> getAllAcademicYear() {
        return ResponseEntity.ok(academicService.getAllAcademicYear());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AcademicYearResponse> deleteAcademicYear(@PathVariable Long id) {
        return ResponseEntity.ok(academicService.deleteAcademicYear(id));
    }
}
