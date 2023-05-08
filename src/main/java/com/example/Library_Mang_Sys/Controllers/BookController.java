package com.example.Library_Mang_Sys.Controllers;

import com.example.Library_Mang_Sys.DTO.RequestDto.BookRequestDto;
import com.example.Library_Mang_Sys.Entity.Book;
import com.example.Library_Mang_Sys.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public String addBook(@RequestBody BookRequestDto bookRequestDto) throws Exception {
      return bookService.addBook(bookRequestDto);
    }
}
