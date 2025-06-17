package com.menglang.student.controller;

import com.menglang.student.dto.academicYear.AcademicYearRequest;
import com.menglang.student.dto.academicYear.AcademicYearResponse;
import com.menglang.student.service.AcademicYear.AcademicService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/academics")
@RestController
@RequiredArgsConstructor
public class AcademicYearController {
    private static final Logger log = LoggerFactory.getLogger(AcademicYearController.class);
    private final AcademicService academicService;

    @PostMapping
    public ResponseEntity<AcademicYearResponse> addAcademicYear(@Valid @RequestBody AcademicYearRequest academicYear) {
        log.info("Invoke post....");
        return ResponseEntity.ok(academicService.createAcademicYear(academicYear));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AcademicYearResponse> getAcademicYearById(@PathVariable Long id) {
        log.info(" acadamic id : {} ",id);
        return ResponseEntity.ok(academicService.getAcademicYear(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AcademicYearResponse> updateAcademicYear(@PathVariable Long id, @RequestBody AcademicYearRequest academicYear) {
        return ResponseEntity.ok(academicService.updateAcademicYear(academicYear, id));
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
