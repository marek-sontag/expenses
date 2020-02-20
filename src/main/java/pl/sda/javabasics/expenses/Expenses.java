package pl.sda.javabasics.expenses;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Scanner;

import static pl.sda.javabasics.expenses.Expense.CATEGORIES;

public class Expenses {

    public static void main(String[] args) {
        System.out.println("Witaj w rejestrze wydatków!");

        System.out.println("Podaj kwotę wydatku:");
        Scanner scanner = new Scanner(System.in);
        String amountString = scanner.nextLine();
        while (!amountString.matches("\\d+(\\.\\d{1,2})?")) {
            System.out.println("Nieprawidłowy format kwoty, wpisz ponownie!");
            amountString = scanner.nextLine();
        }

        System.out.println("Podaj kategorię wydatku:");
        for (Category category: CATEGORIES) {
            System.out.println((category.getNumber() + 1) + ". " + category.getName());
        }
        String categoryString = scanner.nextLine();
        while (!categoryString.matches("[1-5]")) {
            System.out.println("Nieprawidłowa kategoria, wpisz ponownie!");
            categoryString = scanner.nextLine();
        }

        System.out.printf("Kwota: %s, kategoria: %s\n", amountString, categoryString);

        Expense expense = new Expense(LocalDateTime.now(), new BigDecimal(amountString), CATEGORIES[Integer.parseInt(categoryString) - 1]);

    }
}
