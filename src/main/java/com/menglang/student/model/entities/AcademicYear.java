package com.menglang.student.model.entities;

import com.menglang.student.model.audit.AuditEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Table(name = "academic_year")
public class AcademicYear extends AuditEntity<Long>{

    @Column(name = "study_year",unique=true,length=20)
    private String name;

    @Column(name = "start_date",nullable=false,unique=true)
    private LocalDate startDate;

    @Column(name = "end_date",nullable=false,unique=true)
    private LocalDate endDate;

    @Column(length = 150)
    private String description;

//    @OneToMany(mappedBy = "academicYearId")
//    private Set<StudentEnrollment> enrollments=new HashSet<>();

}
