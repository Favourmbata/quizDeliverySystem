package com.ToDo.List.ToDo.List.page.data.model;

import com.ToDo.List.ToDo.List.todoList.data.model.ToDoList;
import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity

public class Page {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private  String title;

    private String subject;


    private LocalDateTime dateWritten;

    private String activitiesDoneOrNot;

    @ManyToOne
    private ToDoList toDoList;
}
