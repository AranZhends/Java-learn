import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            Stack<Integer> stack = new Stack<>();
            int n=in.nextInt();
            for (int i = 0; i < n; i++) {
                String s=in.next();
                    if (s.equals("+")){
                        stack.add((stack.pop()+stack.pop()));
                    }else if(s.equals("-")) {
                        int a = stack.pop();
                        int b = stack.pop();
                        stack.add(b-a);
                    }else if(s.equals("*")){
                        stack.add((stack.pop()*stack.pop()));
                    }else if(s.equals("/")){
                        int a = stack.pop();
                        int b = stack.pop();
                        if (a!=0) {
                            stack.add(b / a);
                        }else {
                            stack.add(0);
                        }
                    }else {
                        stack.add(Integer.parseInt(s));
                    }

                }
            System.out.println(stack.peek());
            }

        }
}
