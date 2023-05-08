package com.example.Library_Mang_Sys.Controllers;

import com.example.Library_Mang_Sys.DTO.RequestDto.IssueBookRequestDto;
import com.example.Library_Mang_Sys.DTO.ResponceDto.IssueBookResponseDto;
import com.example.Library_Mang_Sys.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

@Autowired
    TransactionService transactionService;

    @PostMapping("/add")
    public IssueBookResponseDto  issueBookResponseDto(@RequestBody IssueBookRequestDto issueBookRequestDto) throws Exception {
       return transactionService.issueBookResponseDto(issueBookRequestDto);
    }
}
