import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(overThrow(num));
    }

    private static String overThrow(int num) {
        String str = Integer.toString(num);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = str.length()-1;i>=0;i--) {
            stringBuilder.append(str.charAt(i));
        }
        return stringBuilder.toString();
    }
}
