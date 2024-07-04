package org.group6.assigment2_calculatingcommissions.service;

import org.group6.assigment2_calculatingcommissions.model.CommissionInput;

public class CommissionService {
    public double calculateCommission(CommissionInput input) {
        return CommissionCalculator.calculateCommission(
                input.isSalaried(),
                input.getItemPrice(),
                CommissionCalculator.ItemType.valueOf(input.getItemType().toUpperCase()),
                CommissionCalculator.CustomerType.valueOf(input.getCustomerType().toUpperCase())
        );
    }
}
