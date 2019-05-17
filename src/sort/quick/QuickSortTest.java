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
        Integer[] arr1 = SortTestHelper.makeRandomArray(5000000);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        QuickSort.quickSort(arr1);
        long end = System.currentTimeMillis();
        //3路排序耗时
        System.out.println("3路快速排序耗时  "+ ((end-start)*1.0/1000) +"秒");

        start = System.currentTimeMillis();
        Arrays.sort(arr2);
        end = System.currentTimeMillis();
        //Arrays.sort耗时
        System.out.println("Arrays.sort耗时  "+ ((end-start)*1.0/1000) +"秒");

    }
}
