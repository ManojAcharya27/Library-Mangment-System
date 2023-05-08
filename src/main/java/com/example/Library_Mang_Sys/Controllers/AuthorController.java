package com.example.Library_Mang_Sys.Controllers;

import com.example.Library_Mang_Sys.DTO.RequestDto.AuthorRequestDto;
import com.example.Library_Mang_Sys.Entity.Author;
import com.example.Library_Mang_Sys.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;
    @PostMapping("/add")
    public String  addAuthor(@RequestBody AuthorRequestDto authorRequestDto){
      return authorService.addAuthor(authorRequestDto);
    }
}
