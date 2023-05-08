package com.example.Library_Mang_Sys.Repository;

import com.example.Library_Mang_Sys.Entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card,Integer> {
}
