package com.quizDeliverySystem.quizDeliverySystem.data.repository;

import com.quizDeliverySystem.quizDeliverySystem.data.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
   boolean existsByEmailAddress(String emailAddress);


   Student findByEmailAddress(String emailAddress);

}
