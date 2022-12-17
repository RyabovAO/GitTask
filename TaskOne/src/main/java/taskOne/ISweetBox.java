package taskOne;

public interface ISweetBox {

    void putSweet(Sweets sweet);

    void deleteLastSweet();

    void deleteSweetByIndex(int index);

    void printWeight();

    void printPrice();

    void printBoxInfo();

    public void smartDeleteSweetByWeight(int weight);

    public void smartDeleteSweetByPrice(int price);

}
