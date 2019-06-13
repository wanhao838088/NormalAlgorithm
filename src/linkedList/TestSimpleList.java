package linkedList;

/**
 * Created by LiuLiHao on 2019/6/12 0012 上午 08:25
 * @author : LiuLiHao
 * 描述：测试自己实现的list
 */
public class TestSimpleList {

    public static void main(String[] args) {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();

        //添加元素
        list.add(1);
        list.add(2);
        list.add(3);

        //大小
        System.out.println(list.size());

        //查询
        System.out.println(list.get(0));
        list.addFirst(100);

        System.out.println(list.get(0));
        //删除一个
        list.remove(0);
        System.out.println(list.get(0));

        //清空链表
        list.clear();
        System.out.println(list.size());
    }
}
