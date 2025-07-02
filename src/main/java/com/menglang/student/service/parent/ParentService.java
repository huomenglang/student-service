package com.menglang.student.service.parent;

import com.menglang.student.dto.parent.ParentRequest;
import com.menglang.student.dto.parent.ParentResponse;
import com.menglang.student.model.entities.Parents;
import com.menglang.student.service.BaseService;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface ParentService extends BaseService<ParentRequest, ParentResponse> {
        Page<Parents> getAll(Map<String,String> params);
}
