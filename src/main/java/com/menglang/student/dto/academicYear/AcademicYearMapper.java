package com.menglang.student.dto.academicYear;

import com.menglang.student.model.entities.AcademicYear;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AcademicYearMapper {

    AcademicYear toAcademicYear(AcademicYearRequest academicYearRequest);

    AcademicYearResponse toAcademicYearResponse(AcademicYear academicYear);

    List<AcademicYearResponse> toAcademicYearResponse(List<AcademicYear> academicYears);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    void updateAcademicYearToEntity(AcademicYearRequest academicYearRequest, @MappingTarget AcademicYear academicYear);
}
