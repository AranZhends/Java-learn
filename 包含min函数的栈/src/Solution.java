import java.util.Stack;

public class Solution {

    Stack<Integer> stackTotal = new Stack<Integer>();
    Stack<Integer> stackMin = new Stack<Integer>();
    public void push(int node) {
        stackTotal.push(node);
        if(stackMin.empty()) {
            stackMin.push(node);
        }else{
            if(stackMin.peek()>=node) {
                stackMin.push(node);
            }else stackMin.push(stackMin.peek());
        }
    }

    public void pop() {
        stackTotal.pop();
        stackMin.pop();
    }

    public int top() {
        return stackTotal.peek();
    }

    public int min() {
        return stackMin.peek();
    }
}