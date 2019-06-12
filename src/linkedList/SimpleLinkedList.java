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
     * 添加
     * @param t
     */
    public void add(T t){
        final Node<T> l = last;
        final Node<T> newNode = new Node<>(l,t, null);
        last = newNode;
        if (l == null){
            first = newNode;
        }
        else{
            l.next = newNode;
        }
        size++;
    }

    public T get(int index){
        if (checkIndex(index)){
            //根据范围判断
            if (index < (size >> 1)) {
                Node<T> x = first;
                for (int i = 0; i < index; i++){
                    x = x.next;
                }
                return x.item;
            }else {
                Node<T> x = last;
                for (int i = size - 1; i > index; i--){
                    x = x.prev;
                }
                return x.item;
            }

        }else {
            throw new RuntimeException("下标越界");
        }
    }

    /**
     * 检查下标是否越界
     * @param i
     * @return
     */
    private boolean checkIndex(int i){
        if (i<0 || i>=size){
            return false;
        }
        return true;
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
