package com.quizDeliverySystem.quizDeliverySystem.service.implementation;

import com.quizDeliverySystem.quizDeliverySystem.data.model.Student;
import com.quizDeliverySystem.quizDeliverySystem.data.repository.StudentRepository;
import com.quizDeliverySystem.quizDeliverySystem.dto.request.StudentRequest;
import com.quizDeliverySystem.quizDeliverySystem.dto.request.UpdateRequest;
import com.quizDeliverySystem.quizDeliverySystem.dto.response.StudentResponse;
import com.quizDeliverySystem.quizDeliverySystem.service.interfaces.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
@RequiredArgsConstructor
public class StudentImplService implements StudentService {
    private final StudentRepository studentRepository;


    private String encryptPassword(String password) {
        if (password.contains(" ")) throw new RuntimeException("Invalid input");
        byte[] encodedByte = Base64.getEncoder().encode(password.getBytes(StandardCharsets.UTF_8));
        return new String(encodedByte);
    }

    @Override
    public StudentResponse registerStudent(StudentRequest studentRequest) {
        if (studentRepository.existsByEmailAddress(studentRequest.getEmailAddress()))
            throw new RuntimeException("email exist");
        Student savedStudent = mapAndValidateStudent(studentRequest);
        return StudentResponse.builder()
                .firstName(savedStudent.getFirstName())
                .lastName(savedStudent.getLastName())
                .emailAddress(savedStudent.getEmailAddress())
                .studentClass(savedStudent.getStudentClass()).build();


    }

    private Student mapAndValidateStudent(StudentRequest studentRequest) {
        Student newStudent = new Student();
        newStudent.setFirstName(studentRequest.getFirstName());
        newStudent.setLastName(studentRequest.getLastName());
        newStudent.setEmailAddress(studentRequest.getEmailAddress());
        newStudent.setStudentClass(studentRequest.getStudentClass());
        newStudent.setPassword(encryptPassword(studentRequest.getPassword()));
        Student savedStudent = studentRepository.save(newStudent);
        return savedStudent;
    }

    @Override
    public boolean login(String emailAddress, String password) {
        Student foundStudent = studentRepository.findByEmailAddress(emailAddress);
        if (foundStudent == null) throw new RuntimeException("User not found");
        if (!foundStudent.getPassword().equalsIgnoreCase(encryptPassword(password))) throw new RuntimeException("Incorrect password");
        foundStudent.setLogin(true);
        return studentRepository.save(foundStudent).isLogin();
    }

    @Override
    public StudentResponse updateUser(UpdateRequest updateRequest) {
        Student foundStudent = studentRepository.findByEmailAddress(updateRequest.getEmailAddress());
        if (foundStudent == null)throw new RuntimeException("user not found");
        if (!foundStudent.isLogin())throw new RuntimeException("You have not login");
        foundStudent.setLastName(updateRequest.getLastName());
        Student savedStudent = studentRepository.save(foundStudent);

        return StudentResponse.builder()
                .lastName(savedStudent.getLastName())
                .emailAddress(savedStudent.getEmailAddress())
                .build();
    }

    @Override
    public boolean deleteStudent(String emailAddress) {
        Student foundStudent = new Student();
         studentRepository.delete(foundStudent);
         return studentRepository.existsByEmailAddress(emailAddress);
    }


}
