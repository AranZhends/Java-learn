import java.util.Scanner;

public class Main {
    private static boolean isPrime(int x){
        for(int i = 2;i<=Math.sqrt(x);i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int x = scanner.nextInt();
            int news = 0;
            int min = x;
            int min1 = 0;
            int min2 = 0;
            for (int i = x - 1; i >= x / 2; i--) {
                if (isPrime(i) && isPrime(x - i)) {
                    if (min > i - (x - i)) {
                        min = i - (x - i);
                        min1 = i;
                        min2 = x - i;
                    }
                }
            }
            System.out.println(min2);
            System.out.println(min1);
        }
    }
}
