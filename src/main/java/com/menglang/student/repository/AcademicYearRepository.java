package com.menglang.student.repository;

import com.menglang.student.model.entities.AcademicYear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademicYearRepository extends JpaRepository<AcademicYear, Long>, JpaSpecificationExecutor<AcademicYear> {

    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END FROM AcademicYear a WHERE a.name = ?1")
    public Boolean isAcademicExist(String name);

}
