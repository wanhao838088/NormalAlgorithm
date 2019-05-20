package search;

import java.util.LinkedList;

/**
 * Created by LiuLiHao on 2019/5/18 0018 下午 07:22
 * @author : LiuLiHao
 * 描述：二分搜索树
 */
public class BinSearchTree<K extends Comparable<K>,V> {

    private int count;
    private Node<K,V> root;

    class Node<K,V>{
        private K key;
        private V value;
        private Node<K,V> left;
        private Node<K,V> right;

        public Node(K key,V value) {
            this.key = key;
            this.value = value;
            this.left = this.right = null;
        }
        public Node(Node<K,V> node){
            this.key = node.key;
            this.value = node.value;
            this.left = node.left;
            this.right = node.right;
        }
    }

    /**
     * 创建二分搜索树
     */
    public BinSearchTree() {
        this.count = 0;
        this.root = null;
    }


    /**
     * 插入元素
     * @param k
     * @param v
     */
    public void insert(K k,V v){
        this.root = insert(root,k,v);
    }


    /**
     * 最小的元素
     * @return
     */
    public K min(){
        Node<K,V> node = min(root);
        return node.key;
    }

    private Node<K,V> min(Node<K, V> node) {
        if (node.left==null){
            return node;
        }

        return min(node.left);
    }

    /**
     * 删除任意元素
     * @param k
     */
    public void remove(K k){
        root = remove(root,k);
    }

    private Node<K, V> remove(Node<K, V> node, K k) {
        if (node==null){
            return null;
        }else if(k.compareTo(node.key)<0){
            //从左边删除
            node.left = remove(node.left,k);
            return node;
        }else if(k.compareTo(node.key)>0){
            //从右边删除
            node.right = remove(node.right,k);
            return node;
        }else {

            if (node.left==null){
                //左边为空
                Node<K, V> right = node.right;
                count--;
                return right;
            }
            if (node.right==null){
                //右边为空
                Node<K, V> left = node.left;
                count--;
                return left;
            }
            //选择右边最小的元素为代替节点
            Node<K, V> min = new Node<>(min(node.right));
            count++;
            min.right = removeMin(node);
            min.left = node.left;
            node.left = node.right = null;
            count--;
            return min;
        }
    }

    /**
     * 删除最小元素
     */
    public void removeMin(){
        root = removeMin(root);
    }

    private Node<K, V> removeMin(Node<K, V> node) {
        if (node.left==null){
            //删除这个节点
            Node<K, V> right = node.right;
            node.right = null;
            count--;
            return right;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 删除最大元素
     */
    public void removeMax(){
        root = removeMax(root);
    }

    private Node<K, V> removeMax(Node<K, V> node) {
        if (node.right==null){
            //删除节点
            Node<K, V> left = node.left;
            node.left = null;
            count--;
            return left;
        }
        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 最大元素
     * @return
     */
    public K max(){
        Node<K,V> node = max(root);
        return node.key;
    }

    private Node<K,V> max(Node<K, V> node) {
        if (node.right==null){
            return node;
        }
        return max(node.right);
    }

    /**
     * 是否包含这个key
     * @param k
     * @return
     */
    public boolean contain(K k){
        return contain(root,k);
    }

    private boolean contain(Node<K, V> node, K k) {
        if (node==null){
            return false;
        }else if(k.compareTo(node.key)<0){
            return contain(node.left,k);
        }else {
            return contain(node.right,k);
        }
    }

    /**
     * 使用key查找元素的值
     * @param k
     * @return
     */
    public V search(K k){
        return search(root,k);
    }

    private V search(Node<K, V> node, K k) {
        if (node==null){
            return null;
        }
        //找到了
        if (k==node.key){
            return node.value;
        } else if(k.compareTo(node.key)<0){
            return search(node.left,k);
        }else {
            return search(node.right,k);
        }
    }


    private Node insert(Node<K, V> node, K k, V v) {
        //递归结束
        if (node==null){
            count++;
            return new Node<>(k, v);
        }
        //比较元素和节点的大小
        if (k.compareTo(root.key)==0){
            //相同则更新
            node.value = v;
        }else if (k.compareTo(node.key)<0){
            //k小于  往左放
            node.left = insert(node.left,k,v);
        }else {
            //k大于 往右放
            node.right = insert(node.right,k,v);
        }
        return node;
    }

    /**
     * 广度优先遍历树
     */
    public void orderTree(){
        LinkedList<Node<K, V>> list = new LinkedList<>();
        list.addFirst(root);
        while (!list.isEmpty()){
            Node<K, V> node = list.pop();
            System.out.println(node.key);
            //如果有子节点 继续添加遍历
            if (node.left!=null){
                list.push(node.left);
            }
            if (node.right!=null){
                list.push(node.right);
            }
        }
    }

    /**
     * 前序遍历
     */
    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node<K, V> node) {
        if (node!=null){
            System.out.println(node.key);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * 中序遍历
     */
    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node<K, V> node) {
        if (node!=null){
            inOrder(node.left);
            System.out.println(node.key);
            inOrder(node.right);
        }
    }

    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node<K, V> node) {
        if (node!=null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.key);
        }
    }
    /**
     * 元素个数
     * @return
     */
    public int size(){
        return count;
    }

    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty(){
        return count==0;
    }
}
