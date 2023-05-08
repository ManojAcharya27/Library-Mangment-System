package com.example.Library_Mang_Sys.Services.ServiceImplm;

import com.example.Library_Mang_Sys.DTO.RequestDto.IssueBookRequestDto;
import com.example.Library_Mang_Sys.DTO.ResponceDto.IssueBookResponseDto;
import com.example.Library_Mang_Sys.Entity.Book;
import com.example.Library_Mang_Sys.Entity.Card;
import com.example.Library_Mang_Sys.Entity.Transaction;
import com.example.Library_Mang_Sys.Enum.CardStatus;
import com.example.Library_Mang_Sys.Enum.TransactionStatus;
import com.example.Library_Mang_Sys.Repository.BookRepository;
import com.example.Library_Mang_Sys.Repository.CardRepository;
import com.example.Library_Mang_Sys.Repository.TransactionRepository;
import com.example.Library_Mang_Sys.Services.TransactionService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    CardRepository cardRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    private JavaMailSender emailSender;
    @Override
    public IssueBookResponseDto issueBookResponseDto(IssueBookRequestDto issueBookRequestDto) throws Exception {

        Transaction transaction=new Transaction();
        transaction.setTransactionNumber(String.valueOf(UUID.randomUUID()));
        transaction.setIssueOperation(true);
        Card card;
        try {
            card=cardRepository.findById(issueBookRequestDto.getCardId()).get();
        }catch (Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Invalid Card Id");
        }

        transaction.setCard(card);
        Book book;
        try {
            book=bookRepository.findById(issueBookRequestDto.getBookId()).get();
        }catch (Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Invalid book id");
        }
        transaction.setBook(book);

        if(card.getCardStatus()!= CardStatus.ACTIVE){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Card is not active");
        }

        if(book.isIssued()==true){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Book is not available");
        }
        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        book.setIssued(true);
        book.setCard(card);
        book.getTransactionListForBooks().add(transaction);

        card.getIssuedBook().add(book);
        card.getTransactionListForCard().add(transaction);

        cardRepository.save(card);// this save card,book,transaction.

        // preparing response dto

        IssueBookResponseDto issueBookResponseDto=new IssueBookResponseDto();
        issueBookResponseDto.setBookName(book.getTitle());
        issueBookResponseDto.setTransactionStatus(transaction.getTransactionStatus());
        issueBookResponseDto.setTransactionNumber(transaction.getTransactionNumber());

        String text ="Congrats.!"+card.getStudent().getName()+" "+book.getTitle()+" has been issued ";
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("hmanojacharya27@gmail.com");
        message.setTo(card.getStudent().getEmailId());
        message.setSubject("Issue Book");
        message.setText(text);
        emailSender.send(message);
        return issueBookResponseDto;

    }
}
