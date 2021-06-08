import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            String[] tem = str.split("_");
            StringBuilder res = new StringBuilder();
            for (int i = 0;i<tem.length;i++) {
                if (i == 0) {
                    res.append(tem[i]);
                }else {
                    res.append(tem[i].substring(0,1).toUpperCase() +tem[i].substring(1));
                }
            }
            System.out.println(res);
        }
    }
}
