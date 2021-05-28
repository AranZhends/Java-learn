import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            System.out.println(PerNum(num));
        }

    }

    private static int PerNum(int num) {
        int count = 0;
        for (int i = 2;i<=num;i++) {
            if (sumNum(i) ==i) {
                count++;
            }
        }
        return count;
    }

    //计算某个数的除过本身外的所有因数和
    private static int sumNum(int num) {
        int sum = 0;
        for (int i = 1;i<num;i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
