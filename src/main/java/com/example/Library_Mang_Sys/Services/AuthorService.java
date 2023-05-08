package com.example.Library_Mang_Sys.Services;

import com.example.Library_Mang_Sys.DTO.RequestDto.AuthorRequestDto;
import com.example.Library_Mang_Sys.Entity.Author;

public interface AuthorService {


    public String addAuthor(AuthorRequestDto authorRequestDto);
}
