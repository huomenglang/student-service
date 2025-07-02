package com.menglang.student.repository;

import com.menglang.student.model.entities.StudentEnrollment;
import jakarta.servlet.http.PushBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.Map;

@Repository
public interface StudentEnrollmentRepository extends JpaRepository<StudentEnrollment,Long>, JpaSpecificationExecutor<StudentEnrollment> {
}
