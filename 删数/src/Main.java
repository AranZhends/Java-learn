import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int numb = scanner.nextInt();
            for (int i = 0;i<numb;i++) {
                list.add(i);
            }
            System.out.println(deleteNum(list));
            list.clear();
        }
    }

    private static int deleteNum(ArrayList list) {
        int ret = 0;
        while (list.size() != 1) {
            ret += 2;
            if (ret>=list.size()) {
                ret = ret%list.size();
            }
            list.remove(ret);
        }
        return (int)list.get(0);
    }
}
