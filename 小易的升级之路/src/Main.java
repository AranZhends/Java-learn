import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            int num = scanner.nextInt();
            int ability = scanner.nextInt();
            int []arr = new int[num];
            for (int i = 0;i<num;i++) {
                arr[i] = scanner.nextInt();
            }
            for (int i = 0; i<num;i++) {
                if (ability>=arr[i]) {
                    ability+=arr[i];
                }else if (ability < arr[i]) {
                    ability+= maxdivr(ability,arr[i]);
                }
            }
            System.out.println(ability);
        }
    }

    //求最大公约数
    private static int maxdivr(int ability, int i) {
        int result = 1;
        for (int k = ability;k>0;k--) {
            if (i%k == 0 &&ability%k == 0) {
                result = k;
                break;
            }
        }
        return result;
    }

}
