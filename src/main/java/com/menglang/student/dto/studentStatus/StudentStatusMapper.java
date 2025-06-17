package com.menglang.student.dto.studentStatus;

import com.menglang.student.model.entities.AcademicYear;
import com.menglang.student.model.entities.Student;
import com.menglang.student.model.entities.StudentYearlyStatus;
import com.menglang.student.repository.AcademicYearRepository;
import com.menglang.student.repository.StudentRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public abstract class StudentStatusMapper {
    protected StudentRepository studentRepository;
    protected AcademicYearRepository academicYearRepository;

    public void StudentStatusMapper(StudentRepository studentRepository, AcademicYearRepository academicYearRepository) {
        this.studentRepository = studentRepository;
        this.academicYearRepository = academicYearRepository;
    }


    @Mapping(target = "academicYear",expression = "java(toAcademicYearEntity(dto.academicYearId()))")
    @Mapping(target = "student", expression = "java(toStudentEntity(dto.studentId()))")
    public abstract StudentYearlyStatus toEntity(StudentStatusRequest dto);

    @Named("toAcademicYearEntity")
    public AcademicYear toAcademicYearEntity(Long id){
        return academicYearRepository.findById(id).orElseThrow(()->new RuntimeException("Academic Year Not Found."));
    }

    @Named("toStudentEntity")
    public Student toStudentEntity(Long id){
        return studentRepository.findById(id).orElseThrow(()->new RuntimeException("Student Not Found."));
    }

    public abstract StudentStatusResponse toResponse(StudentYearlyStatus data);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "academicYear",expression = "java(toAcademicYearEntity(request.academicYearId()))")
    @Mapping(target = "student", expression = "java(toStudentEntity(request.studentId()))")
    public abstract void updateToEntity(StudentStatusRequest request,  @MappingTarget StudentYearlyStatus entity);


}
