package com.menglang.student.model.entities;

import com.menglang.student.model.audit.AuditEntity;
import com.menglang.student.model.enums.FamilyType;
import com.menglang.student.model.enums.Gender;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Formula;

import java.io.Serializable;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "parents", indexes = {
        @Index(name = "idx_parents_name", columnList = "full_name,phone_number")
})
public class Parents extends AuditEntity<Long> implements Serializable {

    @Column(name = "full_name", nullable = false, length = 50)
    private String fullName;

    @Enumerated(EnumType.STRING)
    @Column( nullable = false, length = 6)
    private Gender gender;

    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "family_type", nullable = false, length = 15)
    private FamilyType position;

    @Column(name = "description")
    private String description;
}

