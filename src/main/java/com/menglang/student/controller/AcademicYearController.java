package com.menglang.student.controller;

import com.menglang.common.library.dateFormat.DateUtils;
import com.menglang.common.library.page.PageResponse;
import com.menglang.common.library.page.PageResponseHandler;
import com.menglang.student.dto.academicYear.AcademicYearMapper;
import com.menglang.student.dto.academicYear.AcademicYearRequest;
import com.menglang.student.dto.academicYear.AcademicYearRequestParam;
import com.menglang.student.dto.academicYear.AcademicYearResponse;
import com.menglang.student.model.entities.AcademicYear;
import com.menglang.student.service.AcademicYear.AcademicService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hibernate.type.descriptor.DateTimeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/v1/academics")
@RestController
@RequiredArgsConstructor
public class AcademicYearController {
    private static final Logger log = LoggerFactory.getLogger(AcademicYearController.class);
    private final AcademicService academicService;
    private final AcademicYearMapper academicYearMapper;


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


  //  name_like=phone&category_eq=electronics&price_gte=100&price_lte=1000
    @GetMapping("/get-all")
    public ResponseEntity<PageResponse> getAllAcademicYear(
            @RequestParam Map<String, String> params

    ) {
        Page<AcademicYear> academicYearPage=academicService.getAllAcademicYear(params);
        List<AcademicYearResponse> academicYearList=academicYearPage.getContent().stream().map(academicYearMapper::toAcademicYearResponse).toList();

        return PageResponseHandler.success(academicYearList,academicYearPage,"Get Successful");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AcademicYearResponse> deleteAcademicYear(@PathVariable Long id) {
        return ResponseEntity.ok(academicService.deleteAcademicYear(id));
    }
}
