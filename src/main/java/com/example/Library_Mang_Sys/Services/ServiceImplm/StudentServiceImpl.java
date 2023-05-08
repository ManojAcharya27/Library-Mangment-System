package com.example.Library_Mang_Sys.Services.ServiceImplm;

import com.example.Library_Mang_Sys.DTO.RequestDto.StudentMobRequestDto;
import com.example.Library_Mang_Sys.DTO.RequestDto.StudentRequestDto;
import com.example.Library_Mang_Sys.DTO.ResponceDto.CardResponseDto;
import com.example.Library_Mang_Sys.DTO.ResponceDto.StudentResponseDto;
import com.example.Library_Mang_Sys.DTO.ResponceDto.UpdatedStudentMobResponseDto;
import com.example.Library_Mang_Sys.Entity.Card;
import com.example.Library_Mang_Sys.Entity.Student;
import com.example.Library_Mang_Sys.Enum.CardStatus;
import com.example.Library_Mang_Sys.Exception.StudentNotFoundExce;
import com.example.Library_Mang_Sys.Repository.StudentRepository;
import com.example.Library_Mang_Sys.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    // method to add student and generating  student card.
    @Override
    public String addStudent(StudentRequestDto studentRequestDto) {

        // setting entity for student from studentRequestDto
        Student student=new Student();
        student.setName(studentRequestDto.getName());
        student.setAge(studentRequestDto.getAge());
        student.setDepartment(studentRequestDto.getDepartment());
        student.setMblNo(studentRequestDto.getMblNo());
        student.setEmailId(studentRequestDto.getEmail());


        // generating card
        Card card=new Card();
        card.setCardStatus(CardStatus.ACTIVE);
        card.setValidTill("2024-01-01");
        // setting student for card
        card.setStudent(student);


        // setting card for student;
        student.setCard(card);
        // updating db
       studentRepository.save(student);

        return "Student added Successfully";
    }

    @Override
    public StudentResponseDto getStudentById(int id) {
        Student student =studentRepository.findById(id).get();

        StudentResponseDto studentResponseDto=new StudentResponseDto();
        studentResponseDto.setId(student.getId());
        studentResponseDto.setName(student.getName());
        studentResponseDto.setAge(student.getAge());
        studentResponseDto.setDepartment(student.getDepartment());
        studentResponseDto.setMblNo(student.getMblNo());

        CardResponseDto cardResponseDto=new CardResponseDto();
        cardResponseDto.setId(student.getCard().getId());
        cardResponseDto.setIssueDate(student.getCard().getIssueDate());
        cardResponseDto.setValidTill(student.getCard().getValidTill());
        cardResponseDto.setCardStatus(student.getCard().getCardStatus());
        cardResponseDto.setUpdatedOn(student.getCard().getUpdatedOn());

        studentResponseDto.setCardResponseDto(cardResponseDto);

        return studentResponseDto;

    }


    // method to update a student;

    @Override
    public UpdatedStudentMobResponseDto updateMob(StudentMobRequestDto studentMobRequestDto) throws Exception {

        try{
          Student student=studentRepository.findById(studentMobRequestDto.getId()).get();
          student.setMblNo(studentMobRequestDto.getMblNo());
          Student updatedStudent=studentRepository.save(student);

          // preparing response dto
            UpdatedStudentMobResponseDto updatedStudentMobResponseDto=new UpdatedStudentMobResponseDto();
            updatedStudentMobResponseDto.setName(updatedStudent.getName());
            updatedStudentMobResponseDto.setMblNo(updatedStudent.getMblNo());
            return updatedStudentMobResponseDto;
        }catch (Exception e){
            throw new StudentNotFoundExce("Invalid Student Id");
        }

    }
}
