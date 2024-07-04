package org.group6.assigment2_calculatingcommissions.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommissionInput {
    private boolean isSalaried;
    private double itemPrice;
    private String itemType;
    private String customerType;
}
