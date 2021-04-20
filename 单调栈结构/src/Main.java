import java.util.Scanner;

public class Main {
    private static int leftSearch(int idex,int arr[]) {
        if(idex == 0) {
            return -1;
        }
        for (int i = idex-1;i>=0;i--) {
            if(arr[i] < arr[idex] ) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            int arr[] = new int[num];
            for (int i = 0; i<num;i++) {
                arr[i] = scanner.nextInt();
            }
            for (int i = 0; i<num;i++) {
                System.out.println(leftSearch(i, arr) + " "+ rightSearch(i,arr));
            }
        }
    }

    private static int rightSearch(int index, int[] arr) {
        if(index == arr.length) {
            return -1;
        }
        for (int i = index+1;i<arr.length;i++) {
            if (arr[i] < arr[index]) {
                return i;
            }
        }
        return -1;
    }
}
