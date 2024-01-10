package com.quizDeliverySystem.quizDeliverySystem.data.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@RequiredArgsConstructor
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
  private String firstName;
  private String lastName;
  private String emailAddress;
  private String password;
  private  boolean isLogin;
  @Enumerated(EnumType.STRING)
  private StudentClass studentClass;
  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,mappedBy = "student", fetch = FetchType.EAGER)
  private final List<StudentResult>studentResults = new ArrayList<>();



}
