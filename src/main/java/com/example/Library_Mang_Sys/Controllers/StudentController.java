package com.example.Library_Mang_Sys.Controllers;

import com.example.Library_Mang_Sys.DTO.RequestDto.StudentMobRequestDto;
import com.example.Library_Mang_Sys.DTO.RequestDto.StudentRequestDto;
import com.example.Library_Mang_Sys.DTO.ResponceDto.StudentResponseDto;
import com.example.Library_Mang_Sys.DTO.ResponceDto.UpdatedStudentMobResponseDto;
import com.example.Library_Mang_Sys.Entity.Student;
import com.example.Library_Mang_Sys.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("/add")
    public  String addStudent(@RequestBody StudentRequestDto studentRequestDto){
        return studentService.addStudent(studentRequestDto);
    }


    @PutMapping("/update_mob")
    public UpdatedStudentMobResponseDto updateMob(@RequestBody StudentMobRequestDto studentMobRequestDto) throws Exception {
           return studentService.updateMob(studentMobRequestDto);
    }

    @GetMapping("/get_student")
    public StudentResponseDto getStudentById(@RequestParam("id") int id){
        return studentService.getStudentById(id);
    }
}
