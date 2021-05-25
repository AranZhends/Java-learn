import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.next();
            String t = sc.next();
            System.out.println(strInclude(s,t));
        }
    }
    public static int strInclude(String s,String t) {
        int count = 0;
        while (s.contains(t)){
            count++;
            s = s.replaceFirst(t,"");
        }
        return count;
    }
}