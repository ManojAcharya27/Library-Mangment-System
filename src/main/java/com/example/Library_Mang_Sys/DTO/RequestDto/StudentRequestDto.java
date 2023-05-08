package com.example.Library_Mang_Sys.DTO.RequestDto;


import com.example.Library_Mang_Sys.Enum.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentRequestDto {

    private  String name;

    private int age;

    private Department department;

    private String mblNo;

    private String email;


}
