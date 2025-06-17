package com.menglang.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentYearlyStatusRepository extends JpaRepository<com.menglang.student.model.entities.StudentYearlyStatus,Long> {
}
