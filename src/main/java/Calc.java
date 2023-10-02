import java.util.LinkedList;
import java.util.Locale;
import java.util.Scanner;

public class Calc {
    private double goodsSum;
    private final int numPeople;
    private String goodsStr = "";
    private final Scanner scan;
    private final LinkedList<Product> list;

    Calc(int nPeople, Scanner scan) {
        numPeople = nPeople;
        this.scan = scan;
        list = new LinkedList<>();
    }


    void goodsAdd() {
        while (true) {
            double priceProduct = -1;
            System.out.println("Введите название товара:");
            String nameProduct = scan.nextLine();
            if (nameProduct.length() > 0) {
                System.out.println("Введите цену товара в формате рубли.копейки:");
                if (scan.hasNextDouble()) {
                    priceProduct = scan.nextDouble();
                } else {
                    while (true) {
                        if (!(scan.nextLine().equals(""))) break;
                    }
                }
            }
            if (priceProduct > 0) {
                System.out.println("Товар " + nameProduct + " по цене " + String.format(Locale.ENGLISH, "%.2f", priceProduct) + " успешно добавлен!");
                list.add(new Product(nameProduct, priceProduct));
                goodsStr = goodsStr.concat("\n" + nameProduct);
                goodsSum += priceProduct;
                System.out.println("Добавить следующий товар? (Для выхода введите \"завершить\")");
                scan.nextLine();
                String sel = scan.nextLine();
                sel = sel.toLowerCase();
                if (sel.equals("завершить")) {

                    System.out.println("Добавленные товары:");
                    for (Product p : list) {
                        System.out.println(p.name);
                    }
                    goodsSum /= numPeople;
                    StringBuilder strB = new StringBuilder("Сумма на одного человека: ").append(String.format(Locale.ENGLISH, "%.2f ", goodsSum)).append(Formatter.get(goodsSum));
                    System.out.println(strB);
                    break;
                }
            } else {
                System.out.println("Ошибка ввода данных");
            }
        }
    }
}

