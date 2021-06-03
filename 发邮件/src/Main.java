import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            System.out.println(sendEmail(n));
        }

    }
    public static long sendEmail(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;
        return (n-1)*(sendEmail(n-1) + sendEmail(n-2));
    }
}
