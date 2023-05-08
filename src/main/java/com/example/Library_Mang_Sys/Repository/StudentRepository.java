package com.example.Library_Mang_Sys.Repository;

import com.example.Library_Mang_Sys.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
}
