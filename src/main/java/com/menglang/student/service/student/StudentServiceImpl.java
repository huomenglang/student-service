package com.menglang.student.service.student;

import com.menglang.student.dto.student.StudentMapper;
import com.menglang.student.dto.student.StudentRequest;
import com.menglang.student.dto.student.StudentResponse;
import com.menglang.student.model.entities.Student;
import com.menglang.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService{
    private final StudentMapper studentMapper;
private final StudentRepository studentRepository;

    @Override
    public StudentResponse create(StudentRequest dto) {
        Student student=studentMapper.toStudent(dto);
        try{
           Student savedStudent= studentRepository.save(student);
           return studentMapper.studentResponse(savedStudent);
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public StudentResponse update(Long id, StudentRequest dto) {
        Student student=this.getStudentById(id);
        return null;
    }

    @Override
    public StudentResponse delete(Long id) {
        Student student=this.getStudentById(id);
        try {
            studentRepository.deleteById(id);
            return studentMapper.studentResponse(student);
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public Optional<StudentResponse> getById(Long id) {
        Student student=this.getStudentById(id);
        return Optional.ofNullable(studentMapper.studentResponse(student));
    }

    private Student getStudentById(Long id){
        return studentRepository.findById(id).orElseThrow(()->new RuntimeException("Student Not Found!"));
    }
}
