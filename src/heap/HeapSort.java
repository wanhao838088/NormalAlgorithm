package heap;

/**
 * Created by LiuLiHao on 2019/5/17 0017 下午 04:44
 * @author : LiuLiHao
 * 描述：堆排序
 */
public class HeapSort {

    /**
     * 原地堆排序
     *
     * @param arr
     */
    public static void heapSort(Integer[] arr) {
        int n = arr.length;
        //首先把数组变成堆
        for (int i = (n - 1)/2; i >= 0; i--) {
            shiftDown(arr, i, n);
        }
        //把最大的数放到数组最后面 然后交换位置
        for (int i = n-1; i > 0; i--) {
            swap(arr, 0, i);
            shiftDown(arr, 0, i);
        }
    }

    private static void shiftDown(Integer[] arr, int index, int count) {
        while (index * 2 + 1 < count) {
            int j = index * 2 + 1;
            //有右节点
            if (j + 1 < count && arr[j + 1] > arr[j]) {
                j += 1;
            }
            //如果父节点比 子节点还大 那么不需要动
            if (arr[index] > arr[j]) {
                break;
            }
            swap(arr, index, j);
            index = j;
        }
    }

    private static void swap(Integer[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}
