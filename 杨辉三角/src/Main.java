import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        if(numRows <= 0) return ret;
        //第一行的list
        List<Integer> list = new ArrayList<>();
        list.add(1);
        //把第一行的list放到ret当中
        ret.add(list);
        for(int i = 1;i < numRows;i++) {
            List<Integer> curRow = new ArrayList<>();
            curRow.add(1);
            for(int j = 1 ;j < i;j++) {
                //确定的是当前行的每个元素  ==  上一行的当前列+上一行的前一列就是我当前需要添加的数字
                curRow.add(ret.get(i-1).get(j)+ret.get(i-1).get(j-1));
            }
            //手动在当前行的最后一个位置 添加一个1
            curRow.add(1);
            ret.add(curRow);
        }
        return ret;
    }
}


public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generate(4));
    }
}