package stack;

/**
 * Created by LiuLiHao on 2019/6/16 0016 下午 08:06
 * @author : LiuLiHao
 * 描述： 数组模拟栈
 */
public class ArrayStack {

    /**
     * 最大容量
     */
    private int maxSize;
    /**
     * 当前位置
     */
    private int top = -1;

    private Object[] data;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        data = new Object[maxSize];
    }

    /**
     * 加入元素
     * @param obj
     */
    public void push(Object obj){
        if (isFull()){
            throw new RuntimeException("满了");
        }

        top++;
        data[top] = obj;
    }

    /**
     * 出栈
     * @return
     */
    public Object pop(){
        if (isEmpty()){
            throw new RuntimeException("空了");
        }
        Object val = data[top];
        top--;
        return val;
    }

    /**
     * 是否满了
     * @return
     */
    public boolean isFull(){
        return top == maxSize-1;
    }

    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty(){
        return top==-1;
    }

}
