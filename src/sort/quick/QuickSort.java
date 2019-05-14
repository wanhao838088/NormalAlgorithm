package sort.quick;

/**
 * Created by LiuLiHao on 2019/5/13 0013 下午 03:03
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
        //随机取一个元素为参照
        int rand = (int) (Math.random()*(end-start+1) + start);
        swap(arr,start,rand);
        int temp = arr[start];
        int j = start;

        for (int i = start + 1; i <= end; i++) {
            if (arr[i] < temp) {
                swap(arr,i,j+1);
                j++;
            }
        }
        swap(arr,start,j);
        return j;
    }

    private static void swap(int[] arr,int i,int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}
