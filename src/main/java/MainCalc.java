
import java.util.Locale;
import java.util.Scanner;

public class MainCalc {
    public static final Scanner scanner = new Scanner(System.in);
    public static final Locale loc = new Locale("en", "US");
    private static int getInt(String str){
        System.out.println(str);
        while (true) {
            if (scanner.hasNextInt()) {
                int i =scanner.nextInt();
                if(i>1) return i;
            } else {
                scanner.next();
            }
                System.out.println("Ошибка.Введите еще раз");
        }
    }

    public static void main(String[] args) {
        scanner.useLocale(loc);
        int numPeople = getInt("Введите количество человек");
        System.out.println("количество человек:" + numPeople);
        scanner.nextLine();
        Calc clc=new Calc(numPeople);
        clc.goodsAdd();
    }
}
