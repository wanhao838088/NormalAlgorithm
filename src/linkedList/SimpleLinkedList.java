package linkedList;

/**
 * Created by LiuLiHao on 2019/6/12 0012 上午 08:15
 * @author : LiuLiHao
 * 描述：
 */
public class SimpleLinkedList<T> {

    /**
     * 元素个数
     */
    private transient int size;

    /**
     * 起点
     */
    private Node<T> first;
    /**
     * 终点
     */
    private Node<T> last;

    /**
     * 添加元素到末尾
     * @param t
     */
    public void add(T t){
        final Node<T> l = last;
        final Node<T> newNode = new Node<>(l,t, null);
        last = newNode;
        //如果最后一个元素为空  说明没有添加过 直接让开头等于这个
        if (l == null){
            first = newNode;
        }
        else{
            //指向下一个元素
            l.next = newNode;
        }
        size++;
    }

    /**
     * 添加元素到开头
     */
    public void addFirst(T t){
        final Node<T> f = first;
        final Node<T> newNode = new Node<>(null,t,first);
        first = newNode;
        //如果第一个元素为空  说明没有添加过 直接让开头等于这个
        if (f==null){
            last = newNode;
        }else {
            //指向第一个元素
            f.prev = newNode;
        }
        size++;
    }


    /**
     * 添加元素到末尾
     * @param t
     */
    public void addLast(T t){
        add(t);
    }

    /**
     * 根据下标删除元素
     * @param index
     */
    public T remove(int index){
        //检查下标
        checkIndex(index);
        return unLinkNode(getNode(index)).item;
    }

    /**
     * 根据指定元素 从链表中移除
     * @param e
     */
    public Node<T> unLinkNode(Node<T> e){
        T item = e.item;
        Node<T> prev = e.prev;
        Node<T> next = e.next;
        //判断开头
        if (prev==null){
            first = next;
        }else {
            prev.next = next;
            e.prev = null;
        }
        //判断结尾
        if (next==null){
            last = prev;
        }else {
            next.prev = prev;
            e.next = null;
        }
        item = null;
        size--;
        return e;
    }

    /**
     * 根据下标查询
     * @param index
     * @return
     */
    public T get(int index){
        return getNode(index).item;
    }

    /**
     * 获取指定位置的node
     * @param index
     * @return
     */
    private Node<T> getNode(int index){
        checkIndex(index);
        //根据范围判断
        if (index < (size >> 1)) {
            Node<T> x = first;
            for (int i = 0; i < index; i++){
                x = x.next;
            }
            return x;
        }else {
            Node<T> x = last;
            for (int i = size - 1; i > index; i--){
                x = x.prev;
            }
            return x;
        }
    }

    /**
     * 检查下标是否越界
     * @param i
     * @return
     */
    private void checkIndex(int i){
        if (i<0 || i>=size){
            throw new RuntimeException("下标越界");
        }
    }

    /**
     * 个数
     * @return
     */
    public int size(){
        return size;
    }


    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev,E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

}
