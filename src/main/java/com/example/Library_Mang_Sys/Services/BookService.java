package com.example.Library_Mang_Sys.Services;

import com.example.Library_Mang_Sys.DTO.RequestDto.BookRequestDto;
import com.example.Library_Mang_Sys.Entity.Book;

public interface BookService {

    public String addBook(BookRequestDto bookRequestDto) throws Exception;
}
