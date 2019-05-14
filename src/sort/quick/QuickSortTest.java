package sort.quick;

import sort.SortTestHelper;

/**
 * Created by LiuLiHao on 2019/5/13 0013 下午 03:04
 * @author : LiuLiHao
 * 描述：测试归并排序效率
 */
public class QuickSortTest {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        int[] arr1 = SortTestHelper.makeRepeatArray(50000000,0,5);
        QuickSort.quickSort(arr1);
        long end = System.currentTimeMillis();
        //耗时
        System.out.println((end-start)*1.0/1000+"秒");
    }
}
