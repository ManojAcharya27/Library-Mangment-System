package com.example.Library_Mang_Sys.Services;

import com.example.Library_Mang_Sys.DTO.RequestDto.IssueBookRequestDto;
import com.example.Library_Mang_Sys.DTO.ResponceDto.IssueBookResponseDto;

public interface TransactionService {

    public IssueBookResponseDto issueBookResponseDto(IssueBookRequestDto issueBookRequestDto) throws Exception;
}
