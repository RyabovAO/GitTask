package taskOne;

public class Chocolates extends Sweets {

    private String filling;

    public Chocolates(String filling) {
        super("Шоколад", 80, 60);
        this.filling = filling;
    }

    @Override
    public String toString() {
        return "Начинка: " + filling;
    }
}
