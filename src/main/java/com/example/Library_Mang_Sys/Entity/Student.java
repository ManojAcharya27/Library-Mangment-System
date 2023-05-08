package com.example.Library_Mang_Sys.Entity;

import com.example.Library_Mang_Sys.Enum.Department;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "student")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int age;

    @Enumerated(EnumType.STRING)

    private Department department;

    private String mblNo;

    private String emailId;

    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
    Card card;

}
