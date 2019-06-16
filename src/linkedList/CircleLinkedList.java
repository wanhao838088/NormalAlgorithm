package linkedList;

/**
 * Created by LiuLiHao on 2019/6/15 0015 下午 08:11
 * @author : LiuLiHao
 * 描述：单向环形链表 --  约瑟夫
 */
public class CircleLinkedList {

    private Boy first;

    public static void main(String[] args) {

        CircleLinkedList list = new CircleLinkedList();
        list.add(5);

        //list.show();
        list.pop(1,2,5);
    }


    /**
     * 节点
     */
    static class Boy{
        public int num;
        public Boy next;

        public Boy(int num) {
            this.num = num;
        }
    }


    /**
     * 出链表
     * @param startNum 开始位置
     * @param count 隔几个
     * @param size 链表长度
     */
    public void pop(int startNum,int count,int size){
        if (startNum<1 || count<=0 || size<=0 || count>size){
            throw new RuntimeException("参数不正确");
        }
        if (first==null){
            throw new RuntimeException("链表为空");
        }
        //把辅助节点移动到first之前的位置
        Boy help = null;
        Boy cur = this.first;
        while (cur.next!= this.first){
            cur = cur.next;
        }
        help = cur;
        //移动到偏移的位置  startNum - 1
        for (int i = 0; i < startNum - 1; i++) {
            help = help.next;
            first = first.next;
        }

        //开始找位置出链表
        while (true){
            //只有一个元素
            if (help==first){
                break;
            }
            for (int i = 0; i < count - 1; i++) {
                help = help.next;
                first = first.next;
            }
            System.out.println("出去的元素是"+first.num);
            //移除
            first =  first.next;
            help.next = first;
        }
        System.out.println("最后的元素是" + first.num);
    }

    /**
     * 添加指定数量个节点
     * @param count
     */
    public void add(int count){
        if (count<1){
            throw new RuntimeException("exp");
        }
        Boy cur = null;
        for (int i = 1; i <= count; i++) {
            Boy boy = new Boy(i);
            if (i==1){
                first = boy;
                boy.next = first;
                cur = first;
            }else {
                //添加到环形链表里面
                cur.next = boy;
                boy.next = first;
                cur = boy;
            }
        }
    }

    /**
     * 遍历一下链表
     */
    public void show(){
        if (first==null){
            throw new RuntimeException("链表为空");
        }
        Boy cur = this.first;
        while (cur.next!=first){
            System.out.println(cur.num);
            cur = cur.next;
        }
    }
}


