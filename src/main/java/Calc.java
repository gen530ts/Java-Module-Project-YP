public class Calc {
    private double goodsSum;
    private final int numPeople;
    private String goodsStr = "";

    Calc(int nPeople) {
        numPeople = nPeople;
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
            String nameProduct= MainCalc.scanner.nextLine();
            if(nameProduct.length()>0){
                System.out.println("Введите цену товара:");
                if(MainCalc.scanner.hasNextDouble()){
                    priceProduct = MainCalc.scanner.nextDouble();
                }else {
                    while (true){
                        if(!(MainCalc.scanner.nextLine().equals(""))) break;
                    }
                }
            }
            if(priceProduct>0){
                System.out.println("Товар " + nameProduct + " по цене " + String.format(MainCalc.loc,"%.2f", priceProduct) + " успешно добавлен!");
                goodsStr = goodsStr.concat("\n" + nameProduct);
                goodsSum += priceProduct;
                System.out.println("Добавить следующий товар? (Для выхода введите \"завершить\")");
                MainCalc.scanner.nextLine();
                String sel = MainCalc.scanner.nextLine();
                sel = sel.toLowerCase();
                if (sel.equals("завершить")) {
                    System.out.println("Добавленные товары:" + goodsStr);
                    goodsSum /= numPeople;
                    System.out.println("Сумма на одного человека: " + String.format(MainCalc.loc,"%.2f ", goodsSum) + getOutStr(goodsSum));
                    break;
                }
            }else {
                System.out.println("Ошибка ввода данных");
                //if(nameProduct.length()<0) MainCalc.scanner.nextLine();

            }
        }
    }
}
