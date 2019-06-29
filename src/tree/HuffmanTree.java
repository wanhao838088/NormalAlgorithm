package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by LiuLiHao on 2019/6/29 0029 上午 10:24
 * @author : LiuLiHao
 * 描述：哈夫曼树
 */
public class HuffmanTree {

    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};

        TreeNode treeNode = makeHuffmanTree(arr);
        treeNode.preOrder(treeNode);
    }

    private static TreeNode makeHuffmanTree(int[] arr){
        if (arr.length<1){
            throw new RuntimeException();
        }

        //数组转List
        List<TreeNode> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(new TreeNode(arr[i]));
        }


        while (list.size()>1) {
            //排序
            Collections.sort(list);

            //取出前个 组合成树
            TreeNode left = list.get(0);
            TreeNode right = list.get(1);
            TreeNode newNode = new TreeNode(left.val + right.val);

            newNode.left = left;
            newNode.right = right;

            //删除元素
            list.remove(left);
            list.remove(right);
            //加入
            list.add(newNode);
        }
        return list.get(0);
    }


    /**
     * 节点
     */
    static class TreeNode implements Comparable<TreeNode>{
        public int val;
        public TreeNode left;
        public TreeNode right;

        /**
         * 前序遍历
         * @param node
         */
        public void preOrder(TreeNode node){
            System.out.println(node);
            if (node.left!=null){
                preOrder(node.left);
            }
            if (node.right!=null){
                preOrder(node.right);
            }
        }

        public TreeNode(int val) {
            this.val = val;
        }

        /**
         * 升序排列
         * @param o
         * @return
         */
        @Override
        public int compareTo(TreeNode o) {
            return this.val-o.val;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }
}
