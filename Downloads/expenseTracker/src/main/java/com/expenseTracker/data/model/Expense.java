package com.expenseTracker.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.Instant;

@Entity
@Data
public class Expense {
    @Id
    private long id;
    private Instant expenseDate;
    private String description;
    @ManyToOne
    private Category category;

    @ManyToOne
    private AppUser appUser;
}
