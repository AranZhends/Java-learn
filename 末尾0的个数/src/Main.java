import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(zeroNum(num));
    }
x
    private static int zeroNum(int num) {
        int count = 0;
        for (int i = num;i>=5;i--) {
            int temp = i;
            while (temp % 5 == 0) {
                count++;
                temp /= 5;
            }
        }
        return count;
    }

}
