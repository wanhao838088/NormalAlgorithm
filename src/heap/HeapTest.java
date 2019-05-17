package heap;

import sort.SortTestHelper;

import java.util.Arrays;

/**
 * Created by LiuLiHao on 2019/5/15 0015 上午 11:43
 * @author : LiuLiHao
 * 描述：测试堆
 */
public class HeapTest {

    public static void main(String[] args) {
        Integer[] array = SortTestHelper.makeRandomArray(50);

        long start = System.currentTimeMillis();
        HeapSort.heapSort(array);
        long end = System.currentTimeMillis();
        double sec = (end - start)*1.0 / 1000;

        System.out.println(Arrays.toString(array));

        System.out.println("消耗时间: "+ sec +" 秒 ");
    }
}
