package sort.quick;

import sort.SortTestHelper;

import java.util.Arrays;

/**
 * Created by LiuLiHao on 2019/5/13 0013 下午 03:04
 * @author : LiuLiHao
 * 描述：测试归并排序效率
 */
public class QuickSortTest {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        int[] arr = SortTestHelper.makeRandomArray(10);
        QuickSort.quickSort(arr);
        long end = System.currentTimeMillis();
        System.out.println(Arrays.toString(arr));
        //耗时
        System.out.println((end-start)*1.0/1000+"秒");
    }
}
