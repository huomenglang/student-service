package com.menglang.student.service.studentEnrollment;

import com.menglang.student.dto.StudentEnrollment.StudentEnrollmentMapper;
import com.menglang.student.dto.StudentEnrollment.StudentEnrollmentRequest;
import com.menglang.student.dto.StudentEnrollment.StudentEnrollmentResponse;
import com.menglang.student.model.entities.StudentEnrollment;
import com.menglang.student.repository.StudentEnrollmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentEnrollmentServiceImpl implements StudentEnrollmentService{
    private final StudentEnrollmentMapper mapper;
    private final StudentEnrollmentRepository repository;

    @Override
    public StudentEnrollmentResponse create(StudentEnrollmentRequest dto) {
        StudentEnrollment studentEnrollment=mapper.toStudentEnrollment(dto);
        try{
            StudentEnrollment savedStudentEnrollment=repository.save(studentEnrollment);
            return mapper.toResponse(savedStudentEnrollment);
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public StudentEnrollmentResponse update(Long id, StudentEnrollmentRequest dto) {
        StudentEnrollment studentEnrollment=this.findById(id);
        mapper.updateToEntity(dto,studentEnrollment);
        try {
           StudentEnrollment updateStudentEnroll= repository.save(studentEnrollment);
           return mapper.toResponse(updateStudentEnroll);
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public StudentEnrollmentResponse delete(Long id) {
        StudentEnrollment studentEnrollment=this.findById(id);
        try{
            repository.deleteById(id);
            return mapper.toResponse(studentEnrollment);
        }catch (RuntimeException e){
            throw  new RuntimeException(e.getMessage());
        }

    }

    @Override
    public Optional<StudentEnrollmentResponse> getById(Long id) {
        StudentEnrollment studentEnrollment=this.findById(id);
        return Optional.ofNullable(mapper.toResponse(studentEnrollment));
    }

    private StudentEnrollment findById(Long id){
        return repository.findById(id).orElseThrow(()->new RuntimeException("Not Found."));
    }
}
