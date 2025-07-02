package com.menglang.student.service.studentStatus;

import com.menglang.student.dto.studentStatus.StudentStatusRequest;
import com.menglang.student.dto.studentStatus.StudentStatusResponse;
import com.menglang.student.model.entities.StudentEnrollment;
import com.menglang.student.model.entities.StudentYearlyStatus;
import com.menglang.student.service.BaseService;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface StudentYearlyStatusService extends BaseService<StudentStatusRequest, StudentStatusResponse> {
    public Page<StudentYearlyStatus> findAll(Map<String,String> params);
}
