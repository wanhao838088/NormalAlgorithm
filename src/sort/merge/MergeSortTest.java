package sort.merge;

import sort.SortTestHelper;

/**
 * Created by LiuLiHao on 2019/5/13 0013 下午 03:04
 * @author : LiuLiHao
 * 描述：测试归并排序效率
 */
public class MergeSortTest {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        int[] arr = SortTestHelper.makeRandomArray(10000);
        MergeSort.mergeSort(arr);
        long end = System.currentTimeMillis();
        //耗时
        System.out.println((end-start)*1.0/1000+"秒");
    }
}
