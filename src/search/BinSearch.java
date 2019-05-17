package search;

/**
 * Created by LiuLiHao on 2019/5/17 0017 下午 08:42
 *
 * @author : LiuLiHao
 * 描述：二分查找法
 */
public class BinSearch {

    /**
     * 二分查找数组中的元素
     *
     * @param arr
     * @param target
     * @return
     */
    public static int search(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            //防止溢出
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            //判断在哪一边
            if (target < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }


    /**
     * 递归二分查找数组中的元素
     *
     * @param arr
     * @param target
     * @return
     */
    public static int searchBack(int[] arr, int target,int left,int right) {
        if (left>right){
            return -1;
        }
        //防止溢出
        int mid = left + (right - left) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        //判断在哪一边
        if (target < arr[mid]) {
            return searchBack(arr,target,left,mid-1);
        } else {
            return searchBack(arr,target,mid+1,right);
        }
    }
}
