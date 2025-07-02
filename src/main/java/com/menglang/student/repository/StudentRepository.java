package com.menglang.student.repository;

import com.menglang.student.model.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> , JpaSpecificationExecutor<Student> {

    @Query("SELECT CASE WHEN COUNT(s) > 0 THEN true ELSE false END FROM Student s WHERE s.phoneNumber = ?1 AND s.id != ?2")
    public boolean findStudentByPhone(String phone,Long sId);
}
