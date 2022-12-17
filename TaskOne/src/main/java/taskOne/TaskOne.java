package taskOne;

public class TaskOne {

    public static void main(String[] args) {
        SweetBox sweetBox = new SweetBox();
        Candies candie = new Candies("Lime");
        Chocolates chocolate = new Chocolates("Milk");
        Cookies cookie = new Cookies("Chocolate chips");

        sweetBox.putSweet(candie);
        sweetBox.putSweet(chocolate);
        sweetBox.putSweet(cookie);

        sweetBox.printPrice();
        sweetBox.printWeight();

        sweetBox.deleteLastSweet();
        sweetBox.printWeight();

        sweetBox.deleteSweetByIndex(1);
        sweetBox.printWeight();

        sweetBox.deleteSweetByIndex(3);

        sweetBox.putSweet(chocolate);
        sweetBox.putSweet(cookie);
        sweetBox.printBoxInfo();

        sweetBox.smartDeleteSweetByPrice(61);
        sweetBox.printBoxInfo();
        sweetBox.smartDeleteSweetByWeight(300);
        sweetBox.printBoxInfo();
    }

}
