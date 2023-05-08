package com.example.Library_Mang_Sys.Services;

import com.example.Library_Mang_Sys.DTO.RequestDto.StudentMobRequestDto;
import com.example.Library_Mang_Sys.DTO.RequestDto.StudentRequestDto;
import com.example.Library_Mang_Sys.DTO.ResponceDto.StudentResponseDto;
import com.example.Library_Mang_Sys.DTO.ResponceDto.UpdatedStudentMobResponseDto;
import com.example.Library_Mang_Sys.Entity.Student;

public interface StudentService {
    public String addStudent(StudentRequestDto studentRequestDto);

    public StudentResponseDto getStudentById(int id);

    public UpdatedStudentMobResponseDto updateMob(StudentMobRequestDto studentMobRequestDto) throws Exception;
}
