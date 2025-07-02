package com.menglang.student.service.studentEnrollment;

import com.menglang.student.dto.StudentEnrollment.StudentEnrollmentRequest;
import com.menglang.student.dto.StudentEnrollment.StudentEnrollmentResponse;
import com.menglang.student.model.entities.StudentEnrollment;
import com.menglang.student.model.entities.StudentYearlyStatus;
import com.menglang.student.service.BaseService;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface StudentEnrollmentService extends BaseService<StudentEnrollmentRequest, StudentEnrollmentResponse> {

    public Page<StudentEnrollment> findAll(Map<String,String> params);
}
