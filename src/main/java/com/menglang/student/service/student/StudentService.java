package com.menglang.student.service.student;
import com.menglang.student.dto.student.StudentRequest;
import com.menglang.student.dto.student.StudentResponse;
import com.menglang.student.model.entities.Student;
import com.menglang.student.service.BaseService;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface StudentService extends BaseService<StudentRequest, StudentResponse> {

    public Page<Student> getAll(Map<String,String> param);
}
