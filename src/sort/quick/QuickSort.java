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
        //查找对应位置
        int p = partition(arr, start, end);
        quickSort(arr, start, p - 1);
        quickSort(arr, p + 1, end);
    }

    /**
     * 求得分区位置
     *
     * @param arr
     * @param start
     * @param end
     * @return
     */
    private static int partition(int[] arr, int start, int end) {
        //取第一个元素为参照
        int temp = arr[start];
        int j = start;

        for (int i = start + 1; i <= end; i++) {
            if (arr[i] < temp) {
                int t = arr[i];
                arr[i] = arr[j + 1];
                arr[j + 1] = t;

                j++;
            }
        }
        int t = arr[start];
        arr[start] = arr[j];
        arr[j] = t;

        return j;
    }


}
