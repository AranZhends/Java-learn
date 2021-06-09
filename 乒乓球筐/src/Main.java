import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            String[] tem = str.split(" ");
            HashMap<Character, Integer> A = new HashMap<>();
            HashMap<Character, Integer> B = new HashMap<>();
            boolean res = true;
            for (int i = 0; i < tem[0].length(); i++) {
                if (!A.containsKey(tem[0].charAt(i))) {
                    A.put(tem[0].charAt(i), 1);
                } else {
                    A.put(tem[0].charAt(i), A.get(tem[0].charAt(i)) + 1);
                }
            }
            for (int i = 0; i < tem[1].length(); i++) {
                if (!B.containsKey(tem[1].charAt(i))) {
                    B.put(tem[1].charAt(i), 1);
                } else {
                    B.put(tem[1].charAt(i), B.get(tem[1].charAt(i)) + 1);
                }
            }
            Iterator<Character> iterator = B.keySet().iterator();
            while (iterator.hasNext()) {
                Character key = iterator.next();
                if (A.containsKey(key) && A.get(key) >= B.get(key)) {
                    continue;
                }else {
                    res = false;
                    break;
                }
            }
            if (res) System.out.println("Yes");
            if (!res) System.out.println("No");
        }
    }
}