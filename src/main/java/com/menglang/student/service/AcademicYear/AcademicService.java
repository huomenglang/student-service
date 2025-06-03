package com.menglang.student.service.AcademicYear;


import com.menglang.student.dto.academicYear.AcademicYearRequest;
import com.menglang.student.dto.academicYear.AcademicYearResponse;

import java.util.List;

public interface AcademicService {
    AcademicYearResponse createAcademicYear(AcademicYearRequest academicYearRequest);
    AcademicYearResponse getAcademicYear(Long academicYearId);
    AcademicYearResponse updateAcademicYear(AcademicYearRequest academicYearRequest,Long academicYearId);
    AcademicYearResponse deleteAcademicYear(Long academicYearId);
    List<AcademicYearResponse> getAllAcademicYear();
}
