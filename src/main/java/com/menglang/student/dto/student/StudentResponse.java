package com.menglang.student.dto.student;

import com.menglang.student.dto.parent.ParentResponse;
import com.menglang.student.model.enums.Gender;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record StudentResponse (
        Long id,
        String firstName,
        String lastName,
        Gender gender,
        LocalDate birthDate,
        String phoneNumber,
        String address,
        String pobAddress,
        LocalDate enrollmentDate,
        List<ParentResponse> parents,
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime updatedAt,
        String updatedBy
) implements Serializable {
}
