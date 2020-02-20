package pl.sda.javabasics.expenses;

public class Category {

    private int number;
    private String name;

    public Category(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}
