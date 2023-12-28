package com.ToDo.List.ToDo.List.appUser.controller;

import com.ToDo.List.ToDo.List.appUser.service.interfaces.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor

public class ToDoListController {
   private final AppUserService appUserService;



}
