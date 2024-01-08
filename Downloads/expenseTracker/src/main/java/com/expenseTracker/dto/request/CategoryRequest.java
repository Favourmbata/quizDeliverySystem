package com.expenseTracker.dto.request;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class CategoryRequest {
   @ManyToOne(cascade = CascadeType.REMOVE)
    private  long id;
    private String userName;
}
