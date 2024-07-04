package org.group6.assigment2_calculatingcommissions.service;

public class CommissionCalculator {

    public enum CustomerType {
        REGULAR, NON_REGULAR
    }

    public enum ItemType {
        STANDARD, BONUS, OTHER
    }

    public static double calculateCommission(boolean isSalaried, double itemPrice, ItemType itemType, CustomerType customerType) {
        if (itemType == ItemType.STANDARD || customerType == CustomerType.REGULAR) {
            return 0;
        }

        if (itemType == ItemType.BONUS) {
            if (isSalaried) {
                return itemPrice > 1000 ? 25 : 0.05 * itemPrice;
            } else {
                return itemPrice > 1000 ? 75 : 0.10 * itemPrice;
            }
        }

        if (!isSalaried) {
            return itemPrice > 10000 ? 0.05 * itemPrice : 0.10 * itemPrice;
        }

        return 0;
    }
}