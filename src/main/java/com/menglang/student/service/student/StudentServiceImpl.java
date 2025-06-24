package com.menglang.student.service.student;

import com.menglang.common.library.exceptions.common.BadRequestException;
import com.menglang.common.library.exceptions.common.ConflictException;
import com.menglang.common.library.exceptions.common.NotFoundException;
import com.menglang.common.library.page.PageResponseHandler;
import com.menglang.common.library.page.filter.FilterBy;
import com.menglang.common.library.page.parser.BaseSpecification;
import com.menglang.common.library.page.parser.PageableParser;
import com.menglang.common.library.page.parser.QueryParamParser;
import com.menglang.student.dto.student.StudentMapper;
import com.menglang.student.dto.student.StudentRequest;
import com.menglang.student.dto.student.StudentResponse;
import com.menglang.student.model.entities.Student;
import com.menglang.student.repository.ParentRepository;
import com.menglang.student.repository.StudentRepository;
import com.menglang.student.service.student.StudentService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
    private static final Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);
    private final StudentMapper studentMapper;
    private final StudentRepository studentRepository;
    private final ParentRepository parentRepository;

    @Override
    public StudentResponse create(StudentRequest dto) {
        if(this.findStudentByPhone(dto.phoneNumber(),0L)) throw new ConflictException("Student Phone Number already Exist!");
        Student student = studentMapper.toStudent(dto);
        try {
            Student savedStudent = studentRepository.save(student);
            return studentMapper.studentResponse(savedStudent);
        } catch (BadRequestException e) {
            log.info("Unable to create student {} ",e.getMessage());
            throw new BadRequestException(e.getMessage());
        } catch (RuntimeException e){
            log.info("Unable to create student {} ",e.getMessage());
            throw new BadRequestException(e.getMessage());
        }
    }

    @Override
    public StudentResponse update(Long id, StudentRequest dto) {
        if(this.findStudentByPhone(dto.phoneNumber(),id)) throw new ConflictException("Student Phone Number already Exist!");
        Student student = this.getStudentById(id);
        studentMapper.updateToEntity(dto,student);
        try{
            return studentMapper.studentResponse(studentRepository.save(student));
        }catch (BadRequestException e) {
            log.info("Unable to create student {} ",e.getMessage());
            throw new BadRequestException(e.getMessage());
        } catch (RuntimeException e){
            log.info("Unable to create student {} ",e.getMessage());
            throw new BadRequestException(e.getMessage());
        }
    }

    @Override
    public StudentResponse delete(Long id) {
        Student student = this.getStudentById(id);
        try {
            studentRepository.deleteById(id);
            return studentMapper.studentResponse(student);
        } catch (BadRequestException e) {
            log.info("Unable to create student {} ",e.getMessage());
            throw new BadRequestException(e.getMessage());
        } catch (RuntimeException e){
            log.info("Unable to create student {} ",e.getMessage());
            throw new BadRequestException(e.getMessage());
        }

    }

    @Override
    public StudentResponse getById(Long id) {
        Student student = this.getStudentById(id);
        return studentMapper.studentResponse(student);
    }

    private Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new NotFoundException("Student Not Found!"));
    }

    private boolean findStudentByPhone(String phone,Long sId){
        return studentRepository.findStudentByPhone(phone,sId);
    }

    @Override
    public Page<Student> getAll(Map<String, String> param) {
        Pageable pageable= PageableParser.from(param);
        List<FilterBy> filters= QueryParamParser.parse(param);
        Specification<Student>spec = new BaseSpecification<>(filters);
        return studentRepository.findAll(spec,pageable);
    }
}
