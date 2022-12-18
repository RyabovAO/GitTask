package taskOne;

public interface ISweetBox {

    void putSweet(Sweets sweet);

    void deleteLastSweet();

    void deleteSweetByIndex(int index);

    int printWeight();

    void printPrice();

    void printBoxInfo();

    public void smartDeleteSweetByWeight(int weight);

    public void smartDeleteSweetByPrice(int price);

}
