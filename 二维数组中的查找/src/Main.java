import java.util.Scanner;

public class Main {
    public static boolean Find(int target, int [][] array) {
        boolean isFind = false;
        int rows = array.length-1;
        int cols = 0;
        while (rows>=0&&cols<=array[0].length-1) {
            if (array[rows][cols] == target) {
                isFind = true;
                break;
            }
            if (array[rows][cols] > target) {
                rows--;
            }else {
                cols++;
            }
        }
        return isFind;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int target = scanner.nextInt();
            int[][] arrary = {{1,2,8,9},{2,4,9,12},{6,8,11,15}};
            System.out.println(Find(target, arrary));
        }
    }
}
