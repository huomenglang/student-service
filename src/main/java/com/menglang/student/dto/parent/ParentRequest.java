package com.menglang.student.dto.parent;


import com.menglang.student.model.enums.FamilyType;
import com.menglang.student.model.enums.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public record ParentRequest(
        @NotNull
        @NotBlank
        @Size(min = 5, max = 50,message = "Name must be greater than 5 characters")
        String fullName,

        @NotNull(message = "Gender is Require.")
        Gender gender,

        @Size(message = "phone Number is Correct format.",min = 9,max = 15)
        @NotNull
        @NotBlank
        String phoneNumber,

        @NotNull
        @NotBlank
        FamilyType position,

        String description
        ) implements Serializable {
}
