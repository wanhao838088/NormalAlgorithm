package heap;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Created by LiuLiHao on 2019/7/13 0013 下午 04:15
 * @author : LiuLiHao
 * 描述：测试最大堆
 */
public class MaxHeapTest {

    @Test
    public void insertTest(){
        MaxHeap<Integer> heap = new MaxHeap<>(50);
        for (int i = 0; i < 10; i++) {
            heap.insert((int) (Math.random()*50));
        }

        System.out.println(heap.size());
    }

    @Test
    public void removeTest(){
        MaxHeap<Integer> heap = new MaxHeap<>(50);
        for (int i = 0; i < 10; i++) {
            heap.insert((int) (Math.random()*50));
        }

        while (!heap.isEmpty()){
            System.out.println(heap.removeMax());
        }
    }

    @Test
    public void testSort1(){
        Integer[] arr1 = new Integer[10];
        for (int i = 0; i < 10; i++) {
            arr1[i] = (int) (Math.random()*50);
        }
        //创建堆
        MaxHeap<Integer> heap = new MaxHeap<>(arr1);
        for (int i = arr1.length-1; i >=0 ; i--) {
            arr1[i] = heap.removeMax();
        }
        //输出
        System.out.println(Arrays.toString(arr1));
    }
}
