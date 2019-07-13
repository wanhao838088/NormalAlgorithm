package heap;

/**
 * Created by LiuLiHao on 2019/5/14 0014 下午 05:59
 * @author : LiuLiHao
 * 描述：最大堆
 *  子节点数值总是小于父节点
 *  总是一颗完全二叉树
 */
public class MaxHeap<T extends Comparable> {

    /**
     * 父节点位置
     */
    private static final int PARENT_CODE = 2;

    /**
     * 元素个数
     */
    private int count;
    /**
     * 数据
     */
    private T[] data;
    /**
     * 容量
     */
    private int capacity;

    public MaxHeap(int capacity) {
        this.count = 0;
        data = (T[]) new Comparable[capacity+1];
        this.capacity = capacity;
    }

    /**
     * 传入数组 直接构建成堆
     * @param arr
     */
    public MaxHeap(T[] arr){
        data = (T[]) new Comparable[arr.length+1];
        capacity = arr.length;
        count = arr.length;
        //赋值
        for (int i = 0; i < arr.length; i++) {
            data[i+1] = arr[i];
        }
        //调整成堆
        for (int i = arr.length/2; i >=1 ; i--) {
            shiftDown(i);
        }
    }

    /**
     * 插入元素到堆
     * @param t 元素
     */
    public void insert(T t){
        assert count+1<=capacity;
        data[count+1] = t;

        count++;
        shiftUp(count);
    }

    /**
     * 获取最大元素
     * @return
     */
    public T removeMax(){
        assert count>=1;

        T max = data[1];
        //交换元素
        swap(count,1);

        count--;

        //调整堆
        shiftDown(1);

        return max;
    }

    /**
     * 向下调整
     * @param index
     */
    private void shiftDown(int index) {
        while (index*PARENT_CODE<=count){
            //判断是否有右节点
            int j = index*2;
            if (j+1<=count && data[j+1].compareTo(data[j])>0){
                //有右节点 并且比左大
                j++;
            }
            if (data[index].compareTo(data[j])>0){
                //不需要交换
                break;
            }
            swap(index,j);
            index = j;
        }
    }

    /**
     * 向上调整
     * @param index
     */
    private void shiftUp(int index) {
        while (index>1 &&  data[index/2].compareTo(data[index])<0){
            //调整
            swap(index/2,index);
            index/=2;
        }
    }

    /**
     * 交换
     * @param i
     * @param j
     */
    private void swap(int i, int j) {
        T temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }


    /**
     * 堆大小
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
