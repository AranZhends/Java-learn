public class Order {

    public static void main(String[] args) {
        MyList mylist = new MyList(5);
        //插入元素1-5
        mylist.add(0,1);
        mylist.add(1,2);
        mylist.add(2,3);
        mylist.add(3,4);
        mylist.add(4,5);
        mylist.display();
        //查看是否包含元素3
        if(mylist.contains(3)) {
            System.out.println("包含此元素");
        }
        else{
            System.out.println("不包含此元素");
        }
        //表满时增加元素
        mylist.add(5,6);
        mylist.display();
        //查看1位置的元素
        System.out.println("1元素的位置："+mylist.getPos(1));
        //
        //删除元素3
        mylist.remove(3);
        mylist.display();
    }
}
