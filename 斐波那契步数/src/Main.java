import java.util.Scanner;

public class Main {
    private static int Fibon(int n) {
        int a = 0;
        int b = 1;
        int c = 1;
        if (n == 0 || n ==1) {
            return 0;
        }
        while (n>b) {
            c = a+b;
            if (n == c) {
                return 0;
            }
                a = b;
                b = c;
                if (n > a && n < b) {
                    return n - a > b - n ? b - n : n - a;
                }
            }
        return c;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(Fibon(scanner.nextInt()));
        }
    }
}