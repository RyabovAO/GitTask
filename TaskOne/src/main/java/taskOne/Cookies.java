package taskOne;

public class Cookies extends Sweets {

    private String supplement;

    public Cookies(String supplement) {
        super("Печенье", 500, 140);
        this.supplement = supplement;
    }

    @Override
    public String toString() {
        return "Добавка: " + supplement;
    }
}
