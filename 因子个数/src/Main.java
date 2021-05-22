import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            int count = 0;
            int i = 2;
            HashSet<Integer> hashSet = new HashSet();
            while (num != 1) {
                if (num % i == 0) {
                    if (!hashSet.contains(i)) {
                        count++;
                        hashSet.add(i);
                    }
                    num = num/i;
                }else{
                    i++;
                }
            }
            System.out.println(count);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            int count = 0;
            for (int i = 2;i < Math.sqrt(num);i++) {
                int countadd = 0;
                while (num % i == 0) {
                    countadd = 1;
                    num = num/i;
                }
                count +=countadd;
                if (num == 1) break;
            }
            if (num!=1) count++;
            System.out.println(count);
        }
    }
}
