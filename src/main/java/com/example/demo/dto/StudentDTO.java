package com.example.demo.dto;

import lombok.*;

@Getter
@Setter
@ToString
//@AllArgsConstructor
//@NoArgsConstructor
public class StudentDTO {
    private Long id;
    private String studentNumber;
    private String studentName;
    private String studentMobile;
    private String studentMajor;

}
