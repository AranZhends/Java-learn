import java.util.Arrays;

public class Sort {

    public static void Sort(int[] arr) {
        int left = 0;
        int right = arr.length-1;
        while(right>left) {
            while (arr[left] % 2 == 0 && right > left) {
                while (arr[right] % 2 != 0 && right > left) {
                    int temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;
                    left++;
                    right--;
                }
                right--;
            }
            left++;
        }
    }


    public static void main(String[] args) {
        int[] arr = {1,7,5,12,6,9,4,3,11};
        Sort(arr);
        String str = Arrays.toString(arr);
        System.out.println(str);
    }
}
