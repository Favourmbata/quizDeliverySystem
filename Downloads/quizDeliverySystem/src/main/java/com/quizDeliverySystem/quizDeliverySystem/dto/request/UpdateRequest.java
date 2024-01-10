package com.quizDeliverySystem.quizDeliverySystem.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter@RequiredArgsConstructor
public class UpdateRequest {
    private String firstName;
    private String lastName;
    private String emailAddress;
}
