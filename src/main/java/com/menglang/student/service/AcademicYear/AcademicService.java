package com.menglang.student.service.AcademicYear;


import com.menglang.student.dto.academicYear.AcademicYearRequest;
import com.menglang.student.dto.academicYear.AcademicYearRequestParam;
import com.menglang.student.dto.academicYear.AcademicYearResponse;
import com.menglang.student.model.entities.AcademicYear;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface AcademicService {
    AcademicYearResponse createAcademicYear(AcademicYearRequest academicYearRequest);
    AcademicYearResponse getAcademicYear(Long academicYearId);
    AcademicYearResponse updateAcademicYear(AcademicYearRequest academicYearRequest,Long academicYearId);
    AcademicYearResponse deleteAcademicYear(Long academicYearId);
    Page<AcademicYear> getAllAcademicYear(Map<String,String> params);
}
