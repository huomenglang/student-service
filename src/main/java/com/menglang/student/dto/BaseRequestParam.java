package com.menglang.student.dto;

import lombok.*;
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BaseRequestParam {
   private String name;
   private Long page;
    private Short size;
   private String sort;
}
