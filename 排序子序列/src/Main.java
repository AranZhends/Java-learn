import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        int m = 0;
        while(scanner.hasNext()) {
            int  x = scanner.nextInt();
            arr[m] = x;
            m ++;
        }
        int count = 1;
        int j = 0;
        for(int i = 0;i<arr.length-1;i++) {
            if(arr[i]<arr[i+1]) {
                if(j == 0) {
                    j = 1;
                }
                if(j == -1){
                    j = 0;
                    count++;
                }
            }
            if(arr[i] > arr[i+1]) {
                if(j == 0) {
                    j = -1;
                }if(j ==1){
                    j = 0;
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
