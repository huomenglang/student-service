package com.menglang.student.dto.studentStatus;

import com.menglang.student.model.entities.AcademicYear;
import com.menglang.student.model.entities.Student;
import com.menglang.student.model.enums.StudentStatus;

import java.io.Serializable;
import java.time.LocalDateTime;

public record StudentStatusResponse(
        Long id,
        Student student,
        AcademicYear academicYear,
        StudentStatus status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        String createdBy,
        String updatedBy
) implements Serializable {
}
