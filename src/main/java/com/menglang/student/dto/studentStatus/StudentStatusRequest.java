package com.menglang.student.dto.studentStatus;

import com.menglang.student.model.enums.StudentStatus;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

public record StudentStatusRequest(
        @NotBlank
        @NotBlank(message = "Student Must not be null!")
        Long studentId,

        @NotBlank
        @NotBlank(message = "AcademicYear Must not be null!")
        Long academicYearId,

        @NotBlank
        @NotBlank(message = "Status Must not be null!")
        StudentStatus status
) implements Serializable {
}
