package com.menglang.student.dto.StudentEnrollment;

import com.menglang.student.model.enums.StudentStatus;
import org.mapstruct.Mapper;

import java.io.Serializable;


public record StudentEnrollmentRequest(
   Long studentId,
   Long classId,
   Long academicYearId,
   StudentStatus status,
   String description
) implements Serializable {
}
