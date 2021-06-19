import java.util.Stack;

public class Solution {
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if (popA.length == 0||pushA.length == 0||popA.length!=pushA.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0;i<pushA.length;i++) {
            stack.push(pushA[i]);
            while (!stack.isEmpty()&&stack.peek() == popA[j]) {
                j++;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushA = {1,2,3,4,5};
        int[] popA = {4,3,5,1,2};
        System.out.println(IsPopOrder(pushA, popA));
    }
}