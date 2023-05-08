package com.example.Library_Mang_Sys.DTO.RequestDto;

import com.example.Library_Mang_Sys.Entity.Author;
import com.example.Library_Mang_Sys.Enum.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class BookRequestDto {

    private String title;

    private Genre genre;

    private int noOfPages;

    private int price;

    private Author author;


}
