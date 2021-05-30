import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = Integer.parseInt(scanner.nextLine());
            String[] strdic = new String[n];
            for (int i = 0;i<n;i++) {
                strdic[i] = scanner.nextLine();
            }
            System.out.println(conNum(strdic));
        }
    }

    private static int conNum(String[] strdic) {
        int result = 0;
        int resultMax = 0;
        for (int i = 0;i<strdic.length;i++) {
            String[] str = strdic[i].split(" ");
            if (str[1].equals("connect")) {
                result++;
                if (resultMax < result) {
                    resultMax = result;
                }
            }else if (str[1].equals("disconnect")){
                result--;
            }
        }

        return resultMax;
    }
}
