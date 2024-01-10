package com.quizDeliverySystem.quizDeliverySystem.service.interfaces;

import com.quizDeliverySystem.quizDeliverySystem.dto.request.StudentRequest;
import com.quizDeliverySystem.quizDeliverySystem.dto.request.UpdateRequest;
import com.quizDeliverySystem.quizDeliverySystem.dto.response.StudentResponse;

public interface StudentService {


    StudentResponse registerStudent(StudentRequest studentRequest);


    boolean login(String emailAddress, String password);

    StudentResponse updateUser(UpdateRequest studentRequest);

    boolean deleteStudent(String emailAddress);

}
