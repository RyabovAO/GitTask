package taskOne;

public abstract class Sweets {

    private String title;
    private int weight;
    private int price;

    protected Sweets(String title, int weight, int price) {
        this.title = title;
        this.weight = weight;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }
}
