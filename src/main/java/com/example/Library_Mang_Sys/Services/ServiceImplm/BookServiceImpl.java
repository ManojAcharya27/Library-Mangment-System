package com.example.Library_Mang_Sys.Services.ServiceImplm;

import com.example.Library_Mang_Sys.DTO.RequestDto.BookRequestDto;
import com.example.Library_Mang_Sys.Entity.Author;
import com.example.Library_Mang_Sys.Entity.Book;
import com.example.Library_Mang_Sys.Repository.AuthorRepository;
import com.example.Library_Mang_Sys.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    AuthorRepository authorRepository;
    @Override
    public String addBook(BookRequestDto bookRequestDto) throws Exception {
        Author author;
        try {
            author=authorRepository.findById(bookRequestDto.getAuthor().getId()).get();
            Book book=new Book();
            book.setTitle(bookRequestDto.getTitle());
            book.setGenre(bookRequestDto.getGenre());
            book.setNumberOfPages(bookRequestDto.getNoOfPages());
            book.setPrice(bookRequestDto.getPrice());
            author.getBooks().add(book);
            book.setAuthor(author);
            authorRepository.save(author);
            return "Book added Successfully";
        }catch (Exception e){
           throw new Exception("Author Does Not Exist");
        }



    }
}
