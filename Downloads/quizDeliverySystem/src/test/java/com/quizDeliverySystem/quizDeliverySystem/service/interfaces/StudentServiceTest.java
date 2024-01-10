package com.quizDeliverySystem.quizDeliverySystem.service.interfaces;

import com.quizDeliverySystem.quizDeliverySystem.data.model.StudentClass;
import com.quizDeliverySystem.quizDeliverySystem.dto.request.StudentRequest;
import com.quizDeliverySystem.quizDeliverySystem.dto.request.UpdateRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentServiceTest {
    @Autowired
 private StudentService studentService;

    private StudentRequest studentRequest;
    private StudentRequest studentRequest1;
    private StudentRequest studentRequest2;

    private UpdateRequest updateRequest;

    @BeforeEach
    void setUp() {
        studentRequest = new StudentRequest();
        studentRequest.setFirstName("Ngozi");
        studentRequest.setLastName("Emeka");
        studentRequest.setPassword("password");
        studentRequest.setEmailAddress("ngoziEmeka@gmail.com");
        studentRequest.setStudentClass(StudentClass.JSS1);


        studentRequest1 = new StudentRequest();
        studentRequest1.setFirstName("Darling");
        studentRequest1.setLastName("Chigozie");
        studentRequest1.setPassword("password1");
        studentRequest1.setEmailAddress("DarlingChigozie@gmail.com");
        studentRequest1.setStudentClass(StudentClass.JSS1);

        studentRequest2 = new StudentRequest();
        studentRequest2.setFirstName("Mercy");
        studentRequest2.setLastName("Joshson");
        studentRequest2.setPassword("password2");
        studentRequest2.setEmailAddress("MercyJoshSon50@gmail.com");
        studentRequest2.setStudentClass(StudentClass.JSS1);

        updateRequest = new UpdateRequest();
        updateRequest.setLastName("Ini");
        updateRequest.setEmailAddress("ngoziEmeka@gmail.com");
    }

  @Test
    void registerStudent(){
        assertDoesNotThrow(()->{
            studentService.registerStudent(studentRequest2);
        });
  }


  @Test
    void loginStudent(){
        assertDoesNotThrow(()->{
//            studentService.login("ngoziEmeka@gmail.com","password");
//            studentService.login("DarlingChigozie@gmail.com","cGFzc3dvcmQx");
            studentService.login("MercyJoshSon50@gmail.com","password2");
        });

  }

 @Test
    void updateStudentName(){
        assertNotNull(studentService.updateUser(updateRequest));
 }


@Test
    void delete(){
        assertDoesNotThrow(()->{
            studentService.deleteStudent("MercyJoshSon50@gmail.com");
        });
//        assertFalse(studentService.deleteStudent(""));
}


}