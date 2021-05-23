import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder result = new StringBuilder();
        while (sc.hasNext()) {
            int num = sc.nextInt();
            int count = 0;
            result.append(num + " " + "=");
            int j = num;
            for (int i = 2;i<=Math.sqrt(j);i++) {
                while (num % i == 0) {
                   result.append(" "+i+" "+"*");
                    num = num/i;
                    count++;
                }
                if (num == 1) break;
            }
            if (num != 1) result.append(" "+ num);
            if (result.charAt(result.length()-1) == '*') {
                result.deleteCharAt(result.length()-1);
                result.deleteCharAt(result.length()-1);
            }
            System.out.println(result);
            result.setLength(0);
        }
    }
}
