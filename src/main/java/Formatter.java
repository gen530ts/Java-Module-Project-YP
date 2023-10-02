public class Formatter {
    public static String get(double sum) {
        int i = (int) sum % 100;
        int i1 = i % 10;
        int i2 = i / 10;
        if ((i1 == 1) && (i2 != 1)) return "рубль";
        else if ((i1 > 1) && (i1 < 5) && (i2 != 1)) return "рубля";
        else return "рублей";
    }
}
