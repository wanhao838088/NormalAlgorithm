package binarytree;

import org.junit.jupiter.api.Test;

/**
 * Created by LiuLiHao on 2019/7/2 0002 上午 08:37
 * @author : LiuLiHao
 * 描述：测试树
 */
public class TestTree {

    /**
     * 测试添加
     */
    @Test
    public void testAdd(){
        BinarySearchTree tree = new BinarySearchTree();

        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        for (int i : arr) {
            BinarySearchTree.Node node = new BinarySearchTree.Node(i);
            tree.add(node);
        }


        tree.midOrder();
    }

    /**
     * 获取最小的 最大的元素
     */
    @Test
    public void testMin(){
        BinarySearchTree tree = new BinarySearchTree();

        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        for (int i : arr) {
            BinarySearchTree.Node node = new BinarySearchTree.Node(i);
            tree.add(node);
        }

        System.out.println(tree.min());
        System.out.println(tree.max());
    }

    @Test
    public void testInsert(){
        BinarySearchTree tree = new BinarySearchTree();

        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        for (int i : arr) {
            BinarySearchTree.Node node = new BinarySearchTree.Node(i);
            tree.insert(node);
        }

        tree.inOrder();
        System.out.println(tree.size());
    }

    /**
     * 测试删除
     */
    @Test
    public void testRemove(){
        BinarySearchTree tree = new BinarySearchTree();

        int[] arr = {10, 5, 20, 2, 6, 18, 30,3,28,40};
        for (int i : arr) {
            BinarySearchTree.Node node = new BinarySearchTree.Node(i);
            tree.insert(node);
        }
        tree.inOrder();

        BinarySearchTree.Node node = new BinarySearchTree.Node(20);

        //删除10
        tree.remove(node);
        System.out.println("删除后");
        tree.inOrder();
    }
}
