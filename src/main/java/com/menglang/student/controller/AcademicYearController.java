package com.menglang.student.controller;

import com.menglang.student.dto.academicYear.AcademicYearRequest;
import com.menglang.student.dto.academicYear.AcademicYearResponse;
import com.menglang.student.service.AcademicYear.AcademicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping
@RestController("/v1/academics")
@RequiredArgsConstructor
public class AcademicYearController {
    private final AcademicService academicService;

    @PostMapping
    public AcademicYearResponse addAcademicYear(@RequestBody AcademicYearRequest academicYear) {
        return academicService.createAcademicYear(academicYear);
    }

    @GetMapping("/{id}")
    public AcademicYearResponse getAcademicYearById(@PathVariable Long id) {
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
