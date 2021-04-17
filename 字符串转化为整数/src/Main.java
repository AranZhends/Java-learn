import java.util.Scanner;

public class Main {
    public static int strIntoInt(String str) {
        int length = str.length();
        if(length == 0) {
            return 0;
        }
        int flag = 1;
        int i = 0;
        int result = 0;
        if(str.charAt(i) == '-') {
            flag = -1;
            if(i == length-1) {
                return 0;
            }
            i++;
        }
        if(str.charAt(i) == '+') {
            flag = 1;
            if(i == length-1){
                return 0;
            }
            i++;
        }
        if(str.charAt(i) ==' '){
            i++;
        }

        while (i<length) {
            if(str.charAt(i) == ' ') {
                i++;
            }
            if(str.charAt(i)>='0' && str.charAt(i)<='9') {
                result = result*10 + flag*(str.charAt(i)-'0');
                i++;
            }else {
                return 0;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
           String str = scanner.nextLine();
            System.out.println(strIntoInt(str));
        }


    }
}
