import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            Double n = scanner.nextDouble();
            Double r = scanner.nextDouble();
            if (2*r*3.14 >= n) {
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }
    }
}
