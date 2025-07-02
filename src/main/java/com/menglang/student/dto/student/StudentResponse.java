package com.menglang.student.dto.student;

import com.menglang.common.library.page.paginate.BasePageResponse;
import com.menglang.student.dto.parent.ParentResponse;
import com.menglang.student.model.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class StudentResponse extends BasePageResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDate birthDate;
    private String phoneNumber;
    private String address;
    private String pobAddress;
    private LocalDate enrollmentDate;
    private List<ParentResponse> parents;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
}
