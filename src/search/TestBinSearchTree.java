package search;

/**
 * Created by LiuLiHao on 2019/5/18 0018 下午 09:18
 * @author : LiuLiHao
 * 描述：测试二分查找树
 */
public class TestBinSearchTree {

    public static void main(String[] args) {

        BinSearchTree<String, String> tree = new BinSearchTree<>();

        tree.insert("1","bbbb");
        tree.insert("2","cccc");
        tree.insert("3","aaaa");
        tree.insert("4","dddd");

        //最大最小值
        System.out.println(tree.max());
        System.out.println(tree.min());

        //删除最大的
        tree.removeMax();
        System.out.println(tree.max());

        //遍历
//        System.out.println("------前序开始------");
//        tree.preOrder();
//        System.out.println("------中序开始------");
//        tree.inOrder();
//        System.out.println("------后序开始------");
//        tree.postOrder();
//        System.out.println("------广度优先遍历开始------");
//        tree.orderTree();

    }
}
