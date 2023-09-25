import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class MainCalc {
    public static final Scanner scanner = new Scanner(System.in);
    public static final Locale loc = new Locale("en", "US");
    public static void main(String[] args) {
        scanner.useLocale(loc);
        int numPeople = 0;
        System.out.println("Введите количество человек");
        while (true) {
            try {
                numPeople = scanner.nextInt();
            } catch (InputMismatchException e) {
                //e.printStackTrace();System.out.println(e.getMessage());
                scanner.nextLine();
                //continue;

            }

            if (numPeople > 1) {
                break;
            }
            System.out.println("Ошибка.Введите еще раз");
        }
        System.out.println("количество человек:" + numPeople);
        scanner.nextLine();
        Calc clc=new Calc(numPeople);
        clc.goodsAdd();
    }
}
