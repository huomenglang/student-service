package com.menglang.student.model.entities;

import com.menglang.student.model.audit.AuditEntity;
import com.menglang.student.model.enums.StudentStatus;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "student_yearly_status")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentYearlyStatus extends AuditEntity<Long> {

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "academic_year_id")
    private AcademicYear academicYear;


    private StudentStatus status;
}
