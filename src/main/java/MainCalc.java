
import java.util.Locale;
import java.util.Scanner;

public class MainCalc {
   // public static final Locale loc = new Locale("en", "US");
    private static int getInt(Scanner scn){
        System.out.println("Введите количество человек");
        while (true) {
            if (scn.hasNextInt()) {
                int i =scn.nextInt();
                if(i>1) return i;
            } else {
                scn.next();
            }
                System.out.println("Ошибка.Введите еще раз");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.ENGLISH);
        int numPeople = getInt(scanner);
        System.out.println("количество человек:" + numPeople);
        scanner.nextLine();
        Calc clc=new Calc(numPeople,scanner);
        clc.goodsAdd();
    }
}
