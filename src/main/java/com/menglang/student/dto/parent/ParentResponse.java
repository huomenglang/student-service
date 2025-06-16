package com.menglang.student.dto.parent;

import com.menglang.student.model.enums.FamilyType;
import com.menglang.student.model.enums.Gender;

import java.io.Serializable;
import java.time.LocalDateTime;

public record ParentResponse(
        Long id,
        String fullName,
        Gender gender,
        FamilyType familyType,
        String phoneNumber,
        String description,
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime updatedAt,
        String updatedBy
) implements Serializable {
}
