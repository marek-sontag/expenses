package pl.sda.javabasics.expenses;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Expense {

    public static final Category[] CATEGORIES = {
            new Category(0, "Opłaty stałe"),
            new Category(1, "Jedzenie"),
            new Category(2, "Rozrywka"),
            new Category(3, "Ubrania"),
            new Category(4, "Inne")
    };

    private LocalDateTime timestamp;
    private BigDecimal amount;
    private int category;

    public Expense(LocalDateTime timestamp, BigDecimal amount, int category) {
        this.timestamp = timestamp;
        this.amount = amount;
        this.category = category;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public int getCategory() {
        return category;
    }
}
