import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            System.out.println(CountiByte(num));
        }

    }

    private static int CountiByte(int num) {
        int count = 0;
        int max = 0;
        while (num / 2 !=0 || num == 1 ) {
            int temp = num %2;
            if (temp == 1 ) {
                count ++;
            }else if (temp == 0) {
                count = 0;
            }
            if (max < count) {
                max = count;
            }
            num /= 2;
        }
        return max;
    }
}
