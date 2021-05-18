import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int result = 0;
            HashMap<Character,Integer> hash = new HashMap<>();
            String string = scanner.nextLine();
            for (int i = 0;i<string.length();i++) {
                if (!hash.containsKey(string.charAt(i))) {
                    hash.put(string.charAt(i),1);
                }else {
                    hash.put(string.charAt(i), hash.get(string.charAt(i)) + 1);
                }
            }
            for (int i = 0;i<string.length();i++) {
                if (hash.get(string.charAt(i)) == 1) {
                    System.out.println(string.charAt(i));
                    result++;
                    break;
                }
            }
            if (result == 0) {
                System.out.println(-1);
            }
        }
    }
}
