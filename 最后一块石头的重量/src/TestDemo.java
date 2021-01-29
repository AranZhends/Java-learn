import java.util.PriorityQueue;

class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> stone = new PriorityQueue<>((i1, i2) -> i2 - i1);
        for(int i = 0;i<stones.length;i++) {
            stone.offer(stones[i]);
        }
        System.out.println(stone.peek());
        while(stone.peek()!=0&&stone.size()!=0) {
            if(stone.size()==1) {
                return stone.peek();
            }
            if(stone.size() == 2) {
                if(stone.peek()==1) return stone.poll()-stone.poll();
            }
            stone.offer(stone.poll()-stone.poll());
        }
        if(stone.size()==0) {
            return 0;
        }else
            return stone.peek();
    }
}
public class TestDemo {
    public static void main(String[] args) {
        int[] stones = {7,5,6,9,10,5}; //10 9 7 6 5 5      7 6 5 5 1    5 5 1 1   1 1 0  0 0
        Solution solution = new Solution();
        System.out.println(solution.lastStoneWeight(stones));
    }
}
