import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str =  scanner.nextLine();
            for (int i = 0;i<str.length();i++) {
                if (str.charAt(i)>='0' && str.charAt(i)<='9') {
                    System.out.print(str.charAt(i));
                }
            }
            System.out.println();
        }
    }
}
