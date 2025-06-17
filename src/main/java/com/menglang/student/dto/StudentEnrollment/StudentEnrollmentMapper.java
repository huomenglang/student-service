package com.menglang.student.dto.StudentEnrollment;
import com.menglang.student.model.entities.AcademicYear;
import com.menglang.student.model.entities.Student;
import com.menglang.student.model.entities.StudentEnrollment;
import com.menglang.student.repository.AcademicYearRepository;
import com.menglang.student.repository.StudentRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public abstract class StudentEnrollmentMapper {

    protected AcademicYearRepository academicYearRepository;
    protected StudentRepository studentRepository;

    public void StudentEnrollmentMapper(AcademicYearRepository academicYearRepository, StudentRepository studentRepository) {
        this.academicYearRepository = academicYearRepository;
        this.studentRepository = studentRepository;
    }


    @Mapping(target = "academicYear", expression = "java(toAcademicYear(request.academicYearId()))")
    @Mapping(target = "student", expression = "java(toStudent(request.studentId()))")
    public abstract StudentEnrollment toStudentEnrollment(StudentEnrollmentRequest request);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "academicYear", expression = "java(toAcademicYear(studentReq.academicYearId()))")
    @Mapping(target = "student", expression = "java(toStudent(studentReq.studentId()))")
    public abstract void updateToEntity(StudentEnrollmentRequest studentReq, @MappingTarget StudentEnrollment studentEnroll);

    public abstract StudentEnrollmentResponse toResponse(StudentEnrollment data);

    @Named("toAcademicYear")
    protected AcademicYear toAcademicYear(Long academicYearId) {
        return academicYearRepository.findById(academicYearId).orElseThrow(() -> new RuntimeException("Academic Year Not Found"));
    }

    @Named("toStudent")
    protected Student toStudent(Long studentId) {
        return studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Academic Year Not Found"));
    }
}
