package com.example.Library_Mang_Sys.DTO.ResponceDto;

import com.example.Library_Mang_Sys.Entity.Card;
import com.example.Library_Mang_Sys.Enum.Department;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentResponseDto {
    private int id;

    private String name;

    private int age;

    private Department department;

    private String mblNo;

     private CardResponseDto cardResponseDto;
}
