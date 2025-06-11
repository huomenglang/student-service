package com.menglang.student.model.entities;

import com.menglang.student.model.audit.AuditEntity;
import com.menglang.student.model.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "students",indexes = {@Index(name = "idx_student_name", columnList = "firstName,lastName")})
public class Student extends AuditEntity<Long> {

    @Column(name = "first_name", nullable = false, length = 30)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 30)
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "phone_number",unique = true)
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "pob_address")
    private String pobAddress;

    @Column(name = "enrollment_date")
    private LocalDate enrollmentDate;

    @Column(name = "parents")
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "student_parent",
        joinColumns =@JoinColumn(name = "student_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "parents_id",referencedColumnName = "id")
    )
    @Builder.Default
    private Set<Parents> parents=new HashSet<>();

    @OneToMany(mappedBy = "student")
    @Builder.Default
    private Set<StudentEnrollment> studentEnrollments=new HashSet<>();



}
