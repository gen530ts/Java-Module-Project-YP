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
            try {
                System.out.println("Введите название товара:");
                String gds = MainCalc.scanner.nextLine();
                //System.out.println("название товара:" + gds);
                System.out.println("Введите цену товара:");
                double price = MainCalc.scanner.nextDouble();
                if (price < 0) throw new Exception();
                System.out.println("Товар " + gds + " по цене " + String.format(MainCalc.loc,"%.2f", price) + " успешно добавлен!");
                System.out.println(price);
                goodsStr = goodsStr.concat("\n" + gds);
                goodsSum += price;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Ошибка ввода данных");
                MainCalc.scanner.nextLine();
                continue;
            }
            MainCalc.scanner.nextLine();
            System.out.println("Добавить товар? (Для выхода введите \"завершить\")");
            String sel = MainCalc.scanner.nextLine();
            sel = sel.toLowerCase();
            if (sel.equals("завершить")) {
                System.out.println("Добавленные товары:" + goodsStr);
                goodsSum /= numPeople;
                System.out.println("Сумма на одного человека: " + String.format(MainCalc.loc,"%.2f ", goodsSum) + getOutStr(goodsSum));
                break;
            }
        }
    }
}

