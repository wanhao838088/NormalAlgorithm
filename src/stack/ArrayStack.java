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

    private int[] data;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        data = new int[maxSize];
    }

    /**
     * 加入元素
     * @param obj
     */
    public void push(int obj){
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
    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("空了");
        }
        int val = data[top];
        top--;
        return val;
    }

    /**
     * 看最后一个元素
     * @return
     */
    public int peekLast(){
        return data[top];
    }

    /**
     * 是否是运算符
     * @return
     */
    public boolean isOperator(char ch){
        return ch=='+' || ch=='-' ||ch=='*' || ch=='/';
    }

    /**
     * 判断运算符优先级
     * @param ch
     * @return
     */
    public int prior(int ch){
        if (ch=='*' || ch=='/'){
            return 1;
        }else if (ch=='+' || ch=='-'){
            return 0;
        }else {
            return -1;
        }
    }

    /**
     * 计算结果
     * @param num1
     * @param num2
     * @param opera
     * @return
     */
    public int calc(int num1,int num2,int opera){
        int result = 0;
        switch (opera){
            case '+':
                result = num1+num2;
                break;
            case '-':
                result = num2-num1;
                break;
            case '*':
                result = num2*num1;
                break;
            case '/':
                result = num2/num1;
                break;
            default:
                break;
        }
        return result;
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
