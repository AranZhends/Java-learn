import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            StringBuilder res = new StringBuilder();
            String str = scanner.nextLine();
            String[] tem = str.split("[^a-zA-Z]+");
            for (int i = tem.length-1;i>=0;i--) {
                res.append(tem[i]);
                if(i!=0) {
                    res.append(" ");
                }
            }
            System.out.println(res);
        }
    }

}
