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
