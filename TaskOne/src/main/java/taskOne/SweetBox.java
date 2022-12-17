package taskOne;

import java.util.ArrayList;

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
    public void printWeight() {
        int weight = 0;
        for (Sweets sweets : listOfSweets) {
            weight += sweets.getWeight();
        }
        System.out.println("Общий вес: " + weight);
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
        for (Sweets sweet : listOfSweets) {
            if(sweet.getWeight() <= weight) {
                listOfSweets.remove(sweet);
            }
        }
    }

    @Override
    public void smartDeleteSweetByPrice(int price) {
        for (Sweets sweet : listOfSweets) {
            if (sweet.getPrice() <= price) {
                listOfSweets.remove(sweet);
            }
        }
    }

}
