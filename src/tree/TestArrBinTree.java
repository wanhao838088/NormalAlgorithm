package tree;

import org.junit.jupiter.api.Test;

/**
 * Created by LiuLiHao on 2019/6/26 0026 下午 07:33
 * 描述：
 */
public class TestArrBinTree {

    public static void main(String[] args) {
        //用树的方式遍历数组
        int[] arr = {1,2,3,4,5,6,7};
        ArrBinTree tree = new ArrBinTree(arr);
        tree.preOrder();
        System.out.println("-------------");
        tree.midOrder();
        System.out.println("-------------");
        tree.postOrder();
    }


    /**
     * 测试树线索化
     */
    @Test
    public void testThreaded(){
        BinSearchTree<String, Integer> tree = new BinSearchTree<>();

        BinSearchTree.Node root = new BinSearchTree.Node("1",3);
        BinSearchTree.Node node2 = new BinSearchTree.Node("3",3);
        BinSearchTree.Node node3 = new BinSearchTree.Node("6",3);
        BinSearchTree.Node node4 = new BinSearchTree.Node("8",3);
        BinSearchTree.Node node5 = new BinSearchTree.Node("10",31);
        BinSearchTree.Node node6 = new BinSearchTree.Node("14",3);

        root.left = node2;
        root.right=node3;
        node2.left=node4;
        node2.right=node5;
        node3.left=node6;

        BinSearchTree<String, Integer> threadedBinaryTree = new BinSearchTree<String, Integer>();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.midThreaded();

        BinSearchTree.Node leftNode = node5.left;
        BinSearchTree.Node rightNode = node5.right;

        System.out.println("10号结点的前驱结点是 ="  + leftNode); //3
        System.out.println("10号结点的后继结点是 ="  + rightNode); //1

    }
}
