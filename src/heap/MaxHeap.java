package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    private int count;
    private List<T> data;

    public MaxHeap() {
        this.count = 0;
        data = new ArrayList<T>();
        data.add(null);
    }

    /**
     * 插入元素到堆
     * @param t 元素
     */
    public void insert(T t){
        data.add(t);
        count++;
        shiftUp(count);
    }

    public T get(){
        if (count<=0){
            return null;
        }
        //取出最大的元素
        T t = data.get(1);

        //交换位置
        swap(1,count);
        count--;
        shiftDown(1);
        return t;
    }

    /**
     * 保证堆一直为最大堆
     * @param index
     */
    private void shiftDown(int index){

        //左节点 = 当前节点 *2
        //右节点 = 当前节点 *2 + 1
        while (index*2 <=count){
            int j = index*2;
            //有右节点
            if (j+1<=count && data.get(j+1).compareTo(data.get(j))>0){
                j+=1;
            }
            //如果父节点比 子节点还大 那么不需要动
            if (data.get(index).compareTo(data.get(j))>0){
                break;
            }
            swap(index,j);
            index = j;
        }
    }

    /**
     * 保持堆为最大堆
     * @param index
     */
    private void shiftUp(int index) {
        while (index>1 && data.get(index/PARENT_CODE).compareTo(data.get(index))<0){
            //交换位置
            swap(index,index/2);
            index/=2;
        }
    }

    /**
     * 交换元素
     * @param i
     * @param j
     */
    private void swap(int i,int j){
        T temp = data.get(i);
        data.set(i,data.get(j));
        data.set(j,temp);
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

    public void print(){
        Object[] objects = data.toArray();
        System.out.println(Arrays.toString(objects));
    }
}
