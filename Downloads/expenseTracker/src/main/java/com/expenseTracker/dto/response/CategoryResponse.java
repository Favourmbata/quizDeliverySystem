package com.expenseTracker.dto.response;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CategoryResponse {
    @ManyToOne(cascade = CascadeType.REMOVE)
    private  long id;
    private String userName;
}
