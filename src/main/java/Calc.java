import java.util.Locale;
import java.util.Scanner;

public class Calc {
    private double goodsSum;
    private final int numPeople;
    private String goodsStr = "";
    private final Scanner scan;

    Calc(int nPeople, Scanner scan) {
        numPeople = nPeople;
        this.scan=scan;
    }

    private String getOutStr(double sum) {
        int i = (int) sum % 100;
        int i1 = i % 10;
        int i2 = i / 10;
        if ((i1 == 1) && (i2 != 1)) return "рубль";
        else if ((i1 > 1) && (i1 < 5) && (i2 != 1)) return "рубля";
        else return "рублей";
    }

    void goodsAdd() {
        while (true) {
            double priceProduct=-1;
            System.out.println("Введите название товара:");
            String nameProduct= scan.nextLine();
            if(nameProduct.length()>0){
                System.out.println("Введите цену товара:");
                if(scan.hasNextDouble()){
                    priceProduct = scan.nextDouble();
                }else {
                    while (true){
                        if(!(scan.nextLine().equals(""))) break;
                    }
                }
            }
            if(priceProduct>0){
                System.out.println("Товар " + nameProduct + " по цене " + String.format(Locale.ENGLISH,"%.2f", priceProduct) + " успешно добавлен!");
                goodsStr = goodsStr.concat("\n" + nameProduct);
                goodsSum += priceProduct;
                System.out.println("Добавить следующий товар? (Для выхода введите \"завершить\")");
                scan.nextLine();
                String sel = scan.nextLine();
                sel = sel.toLowerCase();
                if (sel.equals("завершить")) {
                    System.out.println("Добавленные товары:" + goodsStr);
                    goodsSum /= numPeople;
                    StringBuilder strB=new StringBuilder("Сумма на одного человека: ").append(String.format(Locale.ENGLISH,"%.2f ", goodsSum)).append(getOutStr(goodsSum));
                    System.out.println(strB);
                    //System.out.println("Сумма на одного человека: " + String.format(MainCalc.loc,"%.2f ", goodsSum) + getOutStr(goodsSum));

                    break;
                }
            }else {
                System.out.println("Ошибка ввода данных");
            }
        }
    }
}
