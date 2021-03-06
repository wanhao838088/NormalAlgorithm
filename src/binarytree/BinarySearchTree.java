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
     * 在外部对结点进行左旋转
     */
    public void rotateLeft(Node current){
        Node newNode = new Node(current.val);
        newNode.left = current.left;
        newNode.right = current.right.left;
        current.val = current.right.val;
        current.right = current.right.right;
        current.left = newNode;
    }
    /**
     * 在外部对结点进行右旋转
     */
    public void rotateRight(Node current){
        Node newNode = new Node(current.val);
        newNode.right = current.right;
        newNode.left = current.left.right;
        current.val = current.left.val;
        current.left = current.left.left;
        current.right = newNode;
    }
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

        public Node(Node node) {
            this.val = node.val;
            this.left = node.left;
            this.right = node.right;
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
     * 整颗二叉树高度
     * @return
     */
    public int height(){
        return height(root);
    }

    /**
     * 左二叉树高度
     * @return
     */
    public int leftHeight(){
        if (root!=null && root.left!=null){
            return height(root.left);
        }
        return 0;
    }
    /**
     * 指定元素左二叉树高度
     * @return
     */
    public int leftHeight(Node node){
        if (node==null){
            return 0;
        }else if(node.left!=null){
            return height(node.left);
        }
        return 0;
    }
    /**
     * 右二叉树高度
     * @return
     */
    public int rightHeight(){
        if (root!=null && root.right!=null){
            return height(root.right);
        }
        return 0;
    }

    /**
     * 指定元素右二叉树高度
     * @return
     */
    public int rightHeight(Node node){
        if (node==null){
            return 0;
        }else if(node.right!=null){
            return height(node.right);
        }
        return 0;
    }
    /**
     * 二叉树高度
     * @return
     */
    private int height(Node node){
        return Math.max(node.left==null?0:height(node.left),
                node.right==null?0:height(node.right))+1;
    }

    /**
     * 加入元素
     * @param node
     */
    public void insert(Node node){
        this.root = insert(root,node);
        //判断是否平衡
        if (rightHeight()-leftHeight()>1){
            //需要左旋
            if(root.right != null && leftHeight(root.right) > rightHeight(root.right) ) {
                //先对右子结点进行右旋转
                rotateRight(root.right);
                //然后在对当前结点进行左旋转
                rotateLeft(root);
            } else {
                //直接进行左旋转即可
                rotateLeft(root);
            }
            return;
        }
        if (leftHeight()-rightHeight()>1){
            //需要右旋
            if(root.left != null && rightHeight(root.left) > leftHeight(root.left)) {
                //先对当前结点的左结点(左子树)->左旋转
                rotateLeft(root.left);
                //再对当前结点进行右旋转
                rotateRight(root);
            } else {
                //直接进行右旋转即可
                rotateRight(root);
            }
        }

        size++;
    }

    private Node insert(Node root, Node node) {
        //直接赋值给根元素
        if (root==null){
            return node;
        }

        if (node.val<root.val){
            //继续往左
            root.left = insert(root.left,node);
        }else {
            //放到右边
            root.right = insert(root.right,node);
        }
        return root;
    }

    /**
     * 移除
     * @param node
     */
    public void remove(Node node){
        if (root!=null){
            remove(root,node);
        }
    }

    /**
     * 移除最小的
     */
    public void removeMin(){
        root = removeMin(root);
    }

    public Node removeMin(Node node){
        if (node.left==null){
            //把右节点赋值给当前 如果没有 也没事
            Node right = node.right;
            right = null;

            size--;
            return right;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 移除
     * @param root
     * @param node
     */
    private Node remove(Node root, Node node) {
        if (root==null){
            return null;
        }
        if (node.val<root.val){
            //往左删除
            root.left = remove(root.left,node);
            return root;
        }else if (node.val>root.val){
            //往右删除
            root.right = remove(root.right,node);
            return root;
        }else {
            //进行删除
            if (root.left==null){
                //把右节点赋值过来
                Node right = root.right;
                size--;
                return right;
            }else if(root.right==null){
                //把左节点赋值过来
                Node left = root.left;
                size--;
                return left;
            }
            //获取右边最小的元素
            Node temp = new Node(min(root.right));
            size++;
            temp.right = removeMin(root.right);
            temp.left = root.left;
            //置空
            root.left = root.right = null;
            size--;
            return temp;
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

    /**
     * 中序遍历2
     */
    public void inOrder(){
        if (root!=null){
            inOrder(root);
        }
    }

    /**
     * 中序遍历2
     * @param root
     */
    private void inOrder(Node root) {
        if (root.left!=null){
            inOrder(root.left);
        }
        System.out.println(root);
        if (root.right!=null){
            inOrder(root.right);
        }
    }

}
