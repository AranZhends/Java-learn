import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            double result = (arrage(n)/fact(n))*100;
            System.out.println(String.format("%.2f",result) +"%");
        }
    }

    private static double arrage(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        return (n-1)*(arrage(n-1)+arrage(n-2));
    }

    //求n的阶乘
    private static double fact(int n) {
        if (n==1) return 1;
        return n*fact(n-1);
    }
}
