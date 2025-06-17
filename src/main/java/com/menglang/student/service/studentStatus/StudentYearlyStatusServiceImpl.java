package com.menglang.student.service.studentStatus;

import com.menglang.student.dto.studentStatus.StudentStatusMapper;
import com.menglang.student.dto.studentStatus.StudentStatusRequest;
import com.menglang.student.dto.studentStatus.StudentStatusResponse;
import com.menglang.student.model.entities.StudentYearlyStatus;
import com.menglang.student.repository.StudentYearlyStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentYearlyStatusServiceImpl implements StudentYearlyStatusService{
    private final StudentStatusMapper studentStatusMapper;
    private final StudentYearlyStatusRepository studentYearlyStatusRepository;


    @Override
    public StudentStatusResponse create(StudentStatusRequest dto) {
        StudentYearlyStatus studentYearlyStatus=studentStatusMapper.toEntity(dto);
        try{
            StudentYearlyStatus savedStudentStatus=studentYearlyStatusRepository.save(studentYearlyStatus);
            return studentStatusMapper.toResponse(savedStudentStatus);
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public StudentStatusResponse update(Long id, StudentStatusRequest dto) {
        var studentYearlyStatus=this.findStudentStatusById(id);
        try{
            this.studentStatusMapper.updateToEntity(dto,studentYearlyStatus);
           StudentYearlyStatus updatedData= studentYearlyStatusRepository.save(studentYearlyStatus);
           return studentStatusMapper.toResponse(updatedData);
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public StudentStatusResponse delete(Long id) {
        var studentYearlyStatus=this.findStudentStatusById(id);
        try{
            studentYearlyStatusRepository.deleteById(id);
            return studentStatusMapper.toResponse(studentYearlyStatus);
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public Optional<StudentStatusResponse> getById(Long id) {
        var studentYearlyStatus=this.findStudentStatusById(id);
        return Optional.ofNullable(studentStatusMapper.toResponse(studentYearlyStatus));
    }

    private StudentYearlyStatus findStudentStatusById(Long id){
        return studentYearlyStatusRepository.findById(id).orElseThrow(()->new RuntimeException("Not Found.!"));
    }
}
