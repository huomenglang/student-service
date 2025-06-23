package com.menglang.student.dto.academicYear;

import com.menglang.student.dto.BaseRequestParam;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
public class AcademicYearRequestParam extends BaseRequestParam {
    private LocalDate startDate;
    private LocalDate endDate;


    public AcademicYearRequestParam(String name,  LocalDate startDate, LocalDate endDate,Long page, Short size, String sort) {
        super(name, page, size, sort);
        this.startDate = startDate;
        this.endDate = endDate;
    }


}
