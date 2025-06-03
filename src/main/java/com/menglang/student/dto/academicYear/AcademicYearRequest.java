package com.menglang.student.dto.academicYear;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AcademicYearRequest {

    @NotNull
    @NotBlank(message = "Name is Require!")
    @Size(min = 5,message = "Name must be greater than 5 characters!")
    private String name;

    @NotNull
    @NotBlank(message = "Start date is Require!")
    private LocalDate startDate;

    @NotNull
    @NotBlank(message = "Start date is Require!")
    private LocalDate endDate;

    private String description;
}
