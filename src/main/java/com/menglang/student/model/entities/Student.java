package com.menglang.student.model.entities;

import com.menglang.student.model.audit.AuditEntity;
import com.menglang.student.model.enums.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students", indexes = {
        @Index(name = "idx_student_name", columnList = "first_name,last_name")
})
public class Student extends AuditEntity<Long> implements Serializable {

    @Column(name = "first_name", nullable = false, length = 30)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 30)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(length = 6)
    private Gender gender;

    @Column(name = "birth_date",length = 40)
    private LocalDate birthDate;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "phone_number", unique = true, nullable = false,length = 40)
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "pob_address")
    private String pobAddress;

    @Column(name = "enrollment_date",length = 40)
    private LocalDate enrollmentDate;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "students_parent",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "parents_id")
    )
    @Builder.Default
    private Set<Parents> parents = new HashSet<>();

//    @OneToMany(mappedBy = "student")
//    @Builder.Default
//    private Set<StudentEnrollment> studentEnrollments = new HashSet<>();
}
