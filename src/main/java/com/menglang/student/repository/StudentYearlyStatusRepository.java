package com.menglang.student.repository;

import com.menglang.student.model.entities.StudentEnrollment;
import com.menglang.student.model.entities.StudentYearlyStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface StudentYearlyStatusRepository extends JpaRepository<StudentYearlyStatus,Long>, JpaSpecificationExecutor<StudentYearlyStatus> {

}
