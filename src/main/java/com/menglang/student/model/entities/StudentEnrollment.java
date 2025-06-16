package com.menglang.student.model.entities;


import com.menglang.student.model.audit.AuditEntity;
import com.menglang.student.model.enums.StudentStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "student_enrollment")
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentEnrollment extends AuditEntity<Long> {

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    private Long classId;

    @ManyToOne
    @JoinColumn(name = "academic_year")
    private AcademicYear academicYear;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private StudentStatus status;

    @Column(length = 200)
    private String description;
}
