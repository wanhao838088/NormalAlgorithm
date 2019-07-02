package binarytree;

/**
 * Created by LiuLiHao on 2019/7/2 0002 上午 08:27
 * @author : LiuLiHao
 * 描述：二叉搜索树
 */
public class BinarySearchTree {
    /**
     * 根节点
     */
    Node root = null;
    /**
     * 节点元素
     */
    static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }

        /**
         * 添加
         * @param node
         */
        public void add(Node node){
            if (node==null){
                return;
            }else if (node.val<this.val){
                //加到左边
                if (this.left==null){
                    this.left = node;
                }else {
                    this.left.add(node);
                }
            }else if(node.val>val){
                //加到右边
                if (this.right==null){
                    this.right = node;
                }else {
                    this.right.add(node);
                }
            }
        }

        /**
         * 中序遍历
         */
        public void midOrder(){
            if (this.left!=null){
                this.left.midOrder();
            }
            System.out.println(this);

            if (this.right!=null){
                this.right.midOrder();
            }
        }
        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }


    /**
     * 添加
     * @param node
     */
    public void add(Node node){
        if (root==null){
            root = node;
        }else {
            root.add(node);
        }
    }

    /**
     * 中序遍历
     */
    public void midOrder(){
        if (root!=null){
            root.midOrder();
        }
    }



}
