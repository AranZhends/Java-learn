import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = Integer.parseInt(scanner.nextLine());
            String[] str = new String[n];
            for (int i = 0;i<n;i++) {
                str[i] = scanner.nextLine();
            }
            Arrays.sort(str);
            List<String> list = new ArrayList<>();
            for (int i = 1;i<n;i++) {
                if (!str[i].startsWith(str[i-1] +"/")) {
                    list.add(str[i-1]);
                }
            }
            list.add(str[n-1]);
            for (int i = 0;i<list.size();i++) {
                System.out.println("mkdir -p " +list.get(i));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String[] str = {"/a","/a/b/c/d","/a/b/c"};
        Arrays.sort(str);
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }
    }
}