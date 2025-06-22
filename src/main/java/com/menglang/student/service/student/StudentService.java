package com.menglang.student.service.Student;
import com.menglang.student.dto.student.StudentRequest;
import com.menglang.student.dto.student.StudentResponse;
import com.menglang.student.service.BaseService;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentService extends BaseService<StudentRequest, StudentResponse> {
}
