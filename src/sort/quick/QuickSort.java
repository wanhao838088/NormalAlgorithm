package sort.quick;

/**
 * Created by LiuLiHao on 2019/5/13 0013 下午 03:03
 *
 * @author : LiuLiHao
 * 描述：快速排序
 */
public class QuickSort {

    /**
     * 快速排序
     *
     * @param arr 数组
     */
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int v = arr[start];

        //使用3路的方式
        int lt = start;
        int gt = end + 1;
        int i = start + 1;
        while (i < gt) {
            if (arr[i] < v) {
                //元素小于 放到小于的部分
                swap(arr, i, lt+1);
                lt++;
                i++;
            } else if (arr[i] > v) {
                //元素大于  放到大于的部分
                swap(arr, i, gt - 1);
                gt--;
            } else {
                //相等 放到等于的部分
                i++;
            }
        }
        swap(arr, start, lt);

        quickSort(arr, start, lt - 1);
        quickSort(arr, gt, end);
    }


    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}
