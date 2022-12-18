package taskOne;

import java.util.ArrayList;
import java.util.Iterator;

public class SweetBox implements ISweetBox {

    private ArrayList<Sweets> listOfSweets;

    public SweetBox() {
        listOfSweets = new ArrayList<>();
    }

    @Override
    public void putSweet(Sweets sweets) {
        listOfSweets.add(sweets);
    }

    @Override
    public void deleteLastSweet() {
        listOfSweets.remove(listOfSweets.size() - 1);
    }

    @Override
    public void deleteSweetByIndex(int index) {
        if (index <= listOfSweets.size()) {
            listOfSweets.remove(index);
        } else System.out.println("В коробке нет столько сладостей");
    }

    @Override
    public int printWeight() {
        int weight = 0;
        for (Sweets sweets : listOfSweets) {
            weight += sweets.getWeight();
        }
        System.out.println("Общий вес: " + weight);
        return weight;
    }

    @Override
    public void printPrice() {
        int price = 0;
        for (Sweets sweet : listOfSweets) {
            price += sweet.getPrice();
        }
        System.out.println("Общая цена: " + price);
    }

    @Override
    public void printBoxInfo() {
        for (Sweets sweet : listOfSweets) {
            System.out.println("Наименование: " + sweet.getTitle() + "\nВес:" + sweet.getWeight() + " грамм" + "\nЦена: "
                    + sweet.getPrice() + " рублей" + "\n" + sweet.toString() + ";");
        }
    }

    @Override
    public void smartDeleteSweetByWeight(int weight) {
        Iterator<Sweets> iter = listOfSweets.iterator();
        while (iter.hasNext()) {
            if (iter.next().getWeight() < weight) {
                iter.remove();
            }
        }
    }

    @Override
    public void smartDeleteSweetByPrice(int weight) {
        listOfSweets.sort((s1, s2) -> s2.getPrice() - s1.getPrice());
        while (printWeight() > weight) {
            deleteLastSweet();
        }
    }

}
