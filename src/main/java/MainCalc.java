
import java.util.Locale;
import java.util.Scanner;

public class MainCalc {
    private static int getInt(Scanner scanner) {
        System.out.println("Введите количество человек");
        while (true) {
            if (scanner.hasNextInt()) {
                int numPeople = scanner.nextInt();
                if (numPeople > 1) return numPeople;
            } else {
                scanner.next();
            }
            System.out.println("Ошибка.Введите количество человек еще раз");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.ENGLISH);
        int numPeople = getInt(scanner);
        System.out.println("количество человек:" + numPeople);
        scanner.nextLine();
        Calc clc = new Calc(numPeople, scanner);
        clc.goodsAdd();
    }
}
