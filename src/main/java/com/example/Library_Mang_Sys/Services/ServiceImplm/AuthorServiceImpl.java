package com.example.Library_Mang_Sys.Services.ServiceImplm;

import com.example.Library_Mang_Sys.DTO.RequestDto.AuthorRequestDto;
import com.example.Library_Mang_Sys.Entity.Author;
import com.example.Library_Mang_Sys.Repository.AuthorRepository;
import com.example.Library_Mang_Sys.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    AuthorRepository authorRepository;
    @Override
    public String addAuthor(AuthorRequestDto authorRequestDto) {

        Author author=new Author();
        author.setName(authorRequestDto.getName());
        author.setAge(authorRequestDto.getAge());
        author.setEmail(authorRequestDto.getEmail());

        authorRepository.save(author);
        return "Author added Successfully";
    }
}
