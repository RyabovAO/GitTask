package taskOne;

public class Candies extends Sweets {

    private String taste;

    public Candies(String taste) {
        super("Конфеты", 300, 100);
        this.taste = taste;
    }

    @Override
    public String toString() {
        return "Вкус: " + taste;
    }
}
