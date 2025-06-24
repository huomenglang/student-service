package com.menglang.student.dto.parent;

import com.menglang.common.library.page.paginate.BasePageResponse;
import com.menglang.student.model.enums.FamilyType;
import com.menglang.student.model.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
public class ParentResponse extends BasePageResponse{
    private Long id;
    private String fullName;
    private Gender gender;
    private FamilyType position;
    private String phoneNumber;
    private String description;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
}
