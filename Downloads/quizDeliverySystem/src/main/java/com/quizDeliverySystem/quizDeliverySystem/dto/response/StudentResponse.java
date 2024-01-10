package com.quizDeliverySystem.quizDeliverySystem.dto.response;

import com.quizDeliverySystem.quizDeliverySystem.data.model.StudentClass;
import io.swagger.v3.oas.annotations.servers.Server;
import lombok.*;

@Getter
@Server
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private StudentClass studentClass;
}
