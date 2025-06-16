package com.menglang.student.dto.StudentEnrollment;


import com.menglang.student.model.entities.AcademicYear;
import com.menglang.student.model.entities.Student;
import com.menglang.student.model.enums.StudentStatus;

import java.io.Serializable;
import java.time.LocalDateTime;

public record StudentEnrollmentResponse(
        Long id,
        Student student,
        Long classId,
        AcademicYear academicYear,
        StudentStatus status,
        String description,
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime updatedAt,
        String updatedBy
) implements Serializable {
}
