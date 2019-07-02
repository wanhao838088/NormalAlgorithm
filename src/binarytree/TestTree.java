package binarytree;

import org.junit.jupiter.api.Test;

/**
 * Created by LiuLiHao on 2019/7/2 0002 上午 08:37
 * @author : LiuLiHao
 * 描述：测试树
 */
public class TestTree {

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
}
