package com.ToDo.List.ToDo.List.todoList.data.model;


import com.ToDo.List.ToDo.List.appUser.data.model.AppUser;
import com.ToDo.List.ToDo.List.page.data.model.Page;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ToDoList {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @ManyToOne
    private AppUser appUser;
    private LocalDateTime dateCreated;



    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Page> listOfPage = new ArrayList<>();
}
