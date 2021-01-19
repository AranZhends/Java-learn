import java.util.Scanner;

public class Main {

    public static String reserve(String str,int left,int right) {
        char[] array = str.toCharArray();
        while(left<right) {
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
        return String.valueOf(array);

    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt();
        String str = scan.next();
        str = reserve(str,0,k-1);
        str = reserve(str,k,str.length()-1);
        str = reserve(str,0,str.length()-1);
        System.out.printf(str);
    }


}
