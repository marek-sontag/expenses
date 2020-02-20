package pl.sda.javabasics.expenses;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Expense {

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
