package com.menglang.student.service.studentStatus;

import com.menglang.common.library.exceptions.common.BadRequestException;
import com.menglang.common.library.page.filter.FilterBy;
import com.menglang.common.library.page.parser.BaseSpecification;
import com.menglang.common.library.page.parser.PageableParser;
import com.menglang.common.library.page.parser.QueryParamParser;
import com.menglang.student.dto.studentStatus.StudentStatusMapper;
import com.menglang.student.dto.studentStatus.StudentStatusRequest;
import com.menglang.student.dto.studentStatus.StudentStatusResponse;
import com.menglang.student.model.entities.StudentEnrollment;
import com.menglang.student.model.entities.StudentYearlyStatus;
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
public class StudentYearlyStatusServiceImpl implements StudentYearlyStatusService{
    private static final Logger log = LoggerFactory.getLogger(StudentYearlyStatusServiceImpl.class);
    private final StudentStatusMapper studentStatusMapper;
    private final StudentYearlyStatusRepository studentYearlyStatusRepository;


    @Override
    public StudentStatusResponse create(StudentStatusRequest dto) {
        StudentYearlyStatus studentYearlyStatus=studentStatusMapper.toEntity(dto);
        try{
            StudentYearlyStatus savedStudentStatus=studentYearlyStatusRepository.save(studentYearlyStatus);
            return studentStatusMapper.toResponse(savedStudentStatus);
        }catch (BadRequestException e){
            log.error("Error YearlyStatus: {}",e.getMessage());
            throw new BadRequestException(e.getMessage());
        }catch (RuntimeException e){
            log.error("Error YearlyStatus: {}",e.getMessage());
            throw new BadRequestException(e.getMessage());
        }
    }

    @Override
    public StudentStatusResponse update(Long id, StudentStatusRequest dto) {
        var studentYearlyStatus=this.findStudentStatusById(id);
        try{
            this.studentStatusMapper.updateToEntity(dto,studentYearlyStatus);
           StudentYearlyStatus updatedData= studentYearlyStatusRepository.save(studentYearlyStatus);
           return studentStatusMapper.toResponse(updatedData);
        }catch (BadRequestException e){
            log.error("Error YearlyStatus: {}",e.getMessage());
            throw new BadRequestException(e.getMessage());
        }catch (RuntimeException e){
            log.error("Error YearlyStatus: {}",e.getMessage());
            throw new BadRequestException(e.getMessage());
        }

    }

    @Override
    public StudentStatusResponse delete(Long id) {
        var studentYearlyStatus=this.findStudentStatusById(id);
        try{
            studentYearlyStatusRepository.deleteById(id);
            return studentStatusMapper.toResponse(studentYearlyStatus);
        }catch (BadRequestException e){
            log.error("Error YearlyStatus: {}",e.getMessage());
            throw new BadRequestException(e.getMessage());
        }catch (RuntimeException e){
            log.error("Error YearlyStatus: {}",e.getMessage());
            throw new BadRequestException(e.getMessage());
        }

    }

    @Override
    public StudentStatusResponse getById(Long id) {
        var studentYearlyStatus=this.findStudentStatusById(id);
        return studentStatusMapper.toResponse(studentYearlyStatus);
    }

    private StudentYearlyStatus findStudentStatusById(Long id){
        return studentYearlyStatusRepository.findById(id).orElseThrow(()->new RuntimeException("Not Found.!"));
    }

    @Override
    public Page<StudentYearlyStatus> findAll(Map<String, String> params) {
            Pageable pageable= PageableParser.from(params);
            List<FilterBy> filters= QueryParamParser.parse(params);
            Specification<StudentYearlyStatus> spec=new BaseSpecification(filters);
            return studentYearlyStatusRepository.findAll(spec,pageable);
    }
}
