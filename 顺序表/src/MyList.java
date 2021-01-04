import java.util.Arrays;

public class MyList {
    private int[] elem;
    private int usedSize;
    public  MyList(){
        this.elem = new int[10];
    }
    public  MyList(int n) {
        this.elem = new int[n];
    }
    //增长数组长度
    public void resize() {
        this.elem = Arrays.copyOf(this.elem,2*this.elem.length);
    }
    //查询表是否已满
    public boolean isFull() {
        if(this.usedSize == this.elem.length) {
            return true;
        }
        else
            return false;
    }
    //打印
    public void display() {
        for(int i = 0;i<usedSize;i++) {
            System.out.println(elem[i]);
        }
    }
    //固定位置增加元素
    public void add(int pos,int data) {
        if(isFull()) {
            resize();
        }
        if(usedSize<0||pos>usedSize) {
            return;
        }
        for(int i = usedSize-1;i>=pos;i--) {
            this.elem[i+1] = this.elem[i];
        }
        this.elem[pos] = data;
        usedSize++;
    }
    public boolean contains (int toFind) {
        for(int i = 0;i<usedSize;i++) {
            if(this.elem[i] == toFind) {
                return true;
            }
        }
        return false;
    }
    public int search(int toFind) {
        for(int i = 0;i<usedSize;i++) {
            if(this.elem[i] == toFind) {
                return i;
            }
        }
        return -1;
    }
    public int getPos(int pos) {
        if(usedSize<0||pos>usedSize) {
            return -1;
        }
        return this.elem[pos];
    }
    public void remove(int toRemove){
        int i ;
        for(i = 0 ;i <usedSize;i++) {
            if(toRemove == this.elem[i]) {
                usedSize--;
                break;
            }
        }
        for(int j = i;j<usedSize;j++) {
            this.elem[j] = this.elem[j+1];
        }
    }
    public int size() {
        return usedSize;
    }
    public void clear() {
        usedSize = 0;
    }
}
