package search;

/**
 * Created by LiuLiHao on 2019/5/18 0018 下午 09:18
 * @author : LiuLiHao
 * 描述：测试二分查找树
 */
public class TestBinSearchTree {

    public static void main(String[] args) {

        BinSearchTree<String, String> tree = new BinSearchTree<>();

        tree.insert("b","bbbb");
        tree.insert("c","cccc");
        tree.insert("a","aaaa");
        tree.insert("d","dddd");
        //前序遍历
        System.out.println("------前序开始------");
        tree.preOrder();
        System.out.println("------中序开始------");
        tree.inOrder();
        System.out.println("------后序开始------");
        tree.postOrder();
    }
}
