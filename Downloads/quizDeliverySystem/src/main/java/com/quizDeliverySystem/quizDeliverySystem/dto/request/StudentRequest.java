package com.quizDeliverySystem.quizDeliverySystem.dto.request;

import com.quizDeliverySystem.quizDeliverySystem.data.model.StudentClass;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class StudentRequest {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;
    private StudentClass studentClass;
}
