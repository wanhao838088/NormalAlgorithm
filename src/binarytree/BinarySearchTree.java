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
     * 节点个数
     */
    private int size = 0;

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
     * 最小元素
     * @return
     */
    public Node min(){
        if (root!=null){
            return min(root);
        }else {
            return null;
        }
    }

    /**
     * 最小元素
     * @return
     */
    public Node min(Node root){
        if (root.left==null){
            return root;
        }else {
            return min(root.left);
        }
    }

    /**
     * 最大元素
     * @return
     */
    public Node max(){
        if (root!=null){
            return max(root);
        }else {
            return null;
        }
    }

    /**
     * 最大元素
     * @return
     */
    public Node max(Node root){
        if (root.right==null){
            return root;
        }else {
            return max(root.right);
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
        size++;
    }

    /**
     * 个数
     * @return
     */
    public int size(){
        return size;
    }

    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty(){
        return size==0;
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
