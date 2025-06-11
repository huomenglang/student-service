package com.menglang.student.dto.academicYear;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Data
public class AcademicYearRequest {

    @NotNull
    @NotBlank(message = "Name is Require!")
    @Size(min = 5,message = "Name must be greater than 5 characters!")
    private String name;

    @NotNull(message = "Start date is Require!")
    private LocalDate startDate;

    @NotNull(message = "End date is Require!")
    private LocalDate endDate;

    private String description;
}
