package com.example.Library_Mang_Sys.Entity;

import com.example.Library_Mang_Sys.Enum.CardStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Table(name = "card")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter


public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @CreationTimestamp
    private Date issueDate;
    @UpdateTimestamp
    private Date updatedOn;

    @Enumerated(EnumType.STRING)
    private CardStatus cardStatus;
    private String validTill;
    @OneToOne
    @JoinColumn
    Student student;


    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    List<Book> issuedBook=new ArrayList<>();

    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    List<Transaction> transactionListForCard=new ArrayList<>();
}
