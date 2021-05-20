import java.util.Arrays;

public class Main {
    public static void oddInOddEvenInEven(int[] arr) {
        int len = arr.length;
        int i = 0,j=1;
        while (i<len && j<len) {
            if (arr[len-1]%2==0) {
                swap(arr,len-1,i);
                i+=2;
            }else {
                swap(arr,len-1,j);
                j+=2;
            }
        }
    }

    private static void swap(int[] arr,int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4};
        oddInOddEvenInEven(arr);
        for (int i:arr) {
            System.out.println(i);
        }
    }
}
