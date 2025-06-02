package com.menglang.student.model.entities;

import com.menglang.student.model.audit.AuditEntity;
import com.menglang.student.model.enums.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "parents")
public class Parents extends AuditEntity<Long>{

    @Column(name = "full_name", nullable = false, length = 50)
    private String fullName;

    @Column(name = "gender", nullable = false,length = 6)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "phone_number", nullable = false,unique = true)
    private String phoneNumber;

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "parents")
    @Builder.Default
    private Set<Student> students=new HashSet<>();



}
