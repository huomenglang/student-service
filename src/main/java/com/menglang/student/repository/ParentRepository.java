package com.menglang.student.repository;

import com.menglang.student.model.entities.Parents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentRepository extends JpaRepository<Parents,Long> {
}
