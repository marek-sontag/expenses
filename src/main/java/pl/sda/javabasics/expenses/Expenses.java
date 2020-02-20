package pl.sda.javabasics.expenses;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Scanner;

import static pl.sda.javabasics.expenses.Expense.CATEGORIES;

public class Expenses {

    final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Witaj w rejestrze wydatków!");

        Expense[] expenses = new Expense[100];
        int index = 0;
        int option = -1;
        do {
            printMenu();
            String optionString = scanner.nextLine();
            while (!optionString.matches("[0-4]")) {
                printMenu();
                optionString = scanner.nextLine();
            }
            option = Integer.parseInt(optionString);

            switch (option) {
                case 0:
                    break;
                case 1:
                    expenses[index++] = addExpense();
                    break;
                case 2:
                    showExpenses(expenses);
                    break;
                case 3:
                    showExpensesFromCategory(expenses);
                    break;
                case 4:
                    // show expenses greater than
                    break;
                default:
                    System.out.println("Niepoprawna opcja. Wybierz liczbę od 0-4.");
                    break;
            }
        } while (option != 0);

        System.out.println("Żegnaj!");
    }

    private static void printMenu() {
        System.out.println("Co chcesz zrobić?");
        System.out.println("1. Dodaj wydatek");
        System.out.println("2. Wyświetl wydatki");
        System.out.println("3. Wyświetl wydatki z wybranej kategorii");
        System.out.println("4. Wyświetl wydatki większe niż X");
        System.out.println("0. Zakończ program");
    }

    private static Expense addExpense() {
        System.out.println("Podaj kwotę wydatku:");
        String amountString = scanner.nextLine();
        while (!amountString.matches("\\d+(\\.\\d{1,2})?")) {
            System.out.println("Nieprawidłowy format kwoty, wpisz ponownie!");
            amountString = scanner.nextLine();
        }

        Category category = readCategory();
        System.out.printf("Kwota: %s, kategoria: %s\n", amountString, category.getName());

        return new Expense(LocalDateTime.now(), new BigDecimal(amountString), category);
    }

    private static void showExpenses(Expense[] expenses) {
        if (expenses.length == 0) {
            System.out.println("Brak wydatków");
        }
        for (Expense expense: expenses) {
            if (expense != null) {
                System.out.println(expense.toString());
            }
        }
    }

    private static Category readCategory() {
        System.out.println("Podaj kategorię wydatku:");
        for (Category category: CATEGORIES) {
            System.out.println((category.getNumber() + 1) + ". " + category.getName());
        }
        String categoryString = scanner.nextLine();
        while (!categoryString.matches("[1-5]")) {
            System.out.println("Nieprawidłowa kategoria, wpisz ponownie!");
            categoryString = scanner.nextLine();
        }
        return CATEGORIES[Integer.parseInt(categoryString) - 1];
    }

    private static void showExpensesFromCategory(Expense[] expenses) {
        Category category = readCategory();

        Expense[] expensesFromCategory = new Expense[100];
        int index = 0;
        for (Expense expense: expenses) {
            if (expense != null && expense.getCategory().getNumber() == category.getNumber()) {
                expensesFromCategory[index++] = expense;
            }
        }

        showExpenses(expensesFromCategory);
    }
}
