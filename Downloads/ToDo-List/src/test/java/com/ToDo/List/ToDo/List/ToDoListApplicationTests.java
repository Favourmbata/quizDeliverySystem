package com.ToDo.List.ToDo.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ToDoListApplicationTests {

    @Autowired

    private ToDoListApplication toDoListApplication;

    @BeforeEach
    void setUp() {
        ToDoListApplication toDoListApplication = new ToDoListApplication();

    }


    @Test
    public void createAccountFor() {

    }
//	@Test
//	void contextLoads() {
//	}


}
