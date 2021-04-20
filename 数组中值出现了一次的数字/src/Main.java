import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            int arr[] = new int[num];
            for (int i = 0;i<num;i++) {
                arr[i] = scanner.nextInt();
            }
            for (int i = 0;i<num;i++) {
                if (map.containsKey(arr[i])) {
                    map.put(arr[i],map.get(arr[i])+1);
                }else {
                    map.put(arr[i],1);
                }
            }
            int count = 0;
            int[] sort = new int[2];
            for (int key:map.keySet()) {
                if (map.get(key) == 1) {
                    if (count == 0) {
                        count++;
                        sort[0] = key;
                    }else {
                        sort[1] = key;
                    }
                }
            }
            Arrays.sort(sort);
            System.out.print(sort[0] +" " +sort[1]);
        }
    }
}