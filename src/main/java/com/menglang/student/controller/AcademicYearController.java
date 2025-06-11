package com.menglang.student.controller;

import com.menglang.student.dto.academicYear.AcademicYearRequest;
import com.menglang.student.dto.academicYear.AcademicYearResponse;
import com.menglang.student.service.AcademicYear.AcademicService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/academics")
@RestController
@RequiredArgsConstructor
public class AcademicYearController {
    private static final Logger log = LoggerFactory.getLogger(AcademicYearController.class);
    private final AcademicService academicService;

    @PostMapping
    public AcademicYearResponse addAcademicYear(@Valid @RequestBody AcademicYearRequest academicYear) {
        log.info("Invoke post....");
        return academicService.createAcademicYear(academicYear);
    }

    @GetMapping("/{id}")
    public AcademicYearResponse getAcademicYearById(@PathVariable Long id) {
        log.info(" acadamic id : {} ",id);
        return academicService.getAcademicYear(id);
    }

    @PutMapping("/{id}")
    public AcademicYearResponse updateAcademicYear(@PathVariable Long id, @RequestBody AcademicYearRequest academicYear) {
        return academicService.updateAcademicYear(academicYear, id);
    }

    @GetMapping("/get-all")
    public List<AcademicYearResponse> getAllAcademicYear() {
        return academicService.getAllAcademicYear();
    }

    @DeleteMapping("/{id}")
    public AcademicYearResponse deleteAcademicYear(@PathVariable Long id) {
        return academicService.deleteAcademicYear(id);
    }
}
