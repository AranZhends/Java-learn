import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long []fibon = new long[81];
        fibon[0] = 1;
        fibon[1] = 1;
        for (int i = 2;i<81;i++) {
            fibon[i] = fibon[i-1] + fibon[i-2];
        }
        while (sc.hasNext()) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            long sum = 0;
            for (int i = from-1;i<to;i++) {
                sum+=fibon[i];
            }
            System.out.println(sum);
        }
    }
}
