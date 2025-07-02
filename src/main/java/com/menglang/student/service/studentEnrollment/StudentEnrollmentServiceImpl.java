package com.menglang.student.service.studentEnrollment;

import com.menglang.common.library.exceptions.common.BadRequestException;
import com.menglang.common.library.page.filter.FilterBy;
import com.menglang.common.library.page.parser.BaseSpecification;
import com.menglang.common.library.page.parser.PageableParser;
import com.menglang.common.library.page.parser.QueryParamParser;
import com.menglang.student.dto.StudentEnrollment.StudentEnrollmentMapper;
import com.menglang.student.dto.StudentEnrollment.StudentEnrollmentRequest;
import com.menglang.student.dto.StudentEnrollment.StudentEnrollmentResponse;
import com.menglang.student.model.entities.StudentEnrollment;
import com.menglang.student.repository.StudentEnrollmentRepository;
import com.menglang.student.repository.StudentYearlyStatusRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentEnrollmentServiceImpl implements StudentEnrollmentService{
    private static final Logger log = LoggerFactory.getLogger(StudentEnrollmentServiceImpl.class);
    private final StudentEnrollmentMapper mapper;
    private final StudentEnrollmentRepository repository;


    @Override
    public StudentEnrollmentResponse create(StudentEnrollmentRequest dto) {
        StudentEnrollment studentEnrollment=mapper.toStudentEnrollment(dto);
        try{
            StudentEnrollment savedStudentEnrollment=repository.save(studentEnrollment);
            return mapper.toResponse(savedStudentEnrollment);
        }catch (BadRequestException e){
            log.error("Error enrollment: {}",e.getMessage());
            throw new BadRequestException(e.getMessage());
        }catch (RuntimeException e){
            log.error("Error enrollment: {}",e.getMessage());
            throw new BadRequestException(e.getMessage());
        }

    }

    @Override
    public StudentEnrollmentResponse update(Long id, StudentEnrollmentRequest dto) {
        StudentEnrollment studentEnrollment=this.findById(id);
        mapper.updateToEntity(dto,studentEnrollment);
        try {
           StudentEnrollment updateStudentEnroll= repository.save(studentEnrollment);
           return mapper.toResponse(updateStudentEnroll);
        }catch (BadRequestException e){
            log.error("Error enrollment: {}",e.getMessage());
            throw new BadRequestException(e.getMessage());
        }catch (RuntimeException e){
            log.error("Error enrollment: {}",e.getMessage());
            throw new BadRequestException(e.getMessage());
        }
    }

    @Override
    public StudentEnrollmentResponse delete(Long id) {
        StudentEnrollment studentEnrollment=this.findById(id);
        try{
            repository.deleteById(id);
            return mapper.toResponse(studentEnrollment);
        }catch (BadRequestException e){
            log.error("Error enrollment: {}",e.getMessage());
            throw new BadRequestException(e.getMessage());
        }catch (RuntimeException e){
            log.error("Error enrollment: {}",e.getMessage());
            throw new BadRequestException(e.getMessage());
        }
    }

    @Override
    public StudentEnrollmentResponse getById(Long id) {
        StudentEnrollment studentEnrollment=this.findById(id);
        return mapper.toResponse(studentEnrollment);
    }

    private StudentEnrollment findById(Long id){
        return repository.findById(id).orElseThrow(()->new RuntimeException("Not Found."));
    }

    @Override
    public Page<StudentEnrollment> findAll(Map<String, String> params) {
        Pageable pageable= PageableParser.from(params);
        List<FilterBy> filters= QueryParamParser.parse(params);
        Specification<StudentEnrollment> spec=new BaseSpecification(filters);
        return repository.findAll(spec,pageable);
    }
}
