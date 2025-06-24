package com.menglang.student.repository;

import com.menglang.student.model.entities.Parents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentRepository extends JpaRepository<Parents,Long>, JpaSpecificationExecutor<Parents> {

    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END FROM Parents a WHERE a.phoneNumber = ?1 AND a.id != ?2")
    public Boolean findParentByPhoneNumber(String phone,Long pId);
}
