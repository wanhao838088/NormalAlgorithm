package search;

import java.util.Arrays;

/**
 * Created by LiuLiHao on 2019/6/19 0019 上午 09:04
 * @author : LiuLiHao
 * 描述：斐波那契查找
 */
public class FibonacciSearch {

    public static void main(String[] args) {
        int[] arr  ={1,2,3,4,5,6,7};
        int search = search(arr,5);
        System.out.println(search);
    }


    /**
     * fibonacci查找
     * @param arr 排序的数组
     * @param val 要查找的值
     * @return
     */
    public static int search(int[] arr, int val) {

        //开始和结束位置
        int low = 0, high = arr.length - 1;

        int[] fib = fibonacci();
        int k = 0, mid = 0;
        //获取到斐波那契分割数值的下标
        while (fib[k] - 1 < high) {
            k++;
        }

        //如果数组长度不够 先复制
        int[] temp = Arrays.copyOf(arr, fib[k]);

        //后面的数字使用 arr的最大的数字填充
        for (int i = high+1; i < temp.length; i++) {
            temp[i] = arr[high];
        }

        while (low<high){
            mid = low + fib[k-1]-1;
            if (val<temp[mid]){
                //要查找的数比现在的小
                high = mid-1;
                k--;
            }else if (val>temp[mid]){
                //要查找的数比现在的大
                high = mid+1;
                k-=2;
            }else {
                if (mid<=high){
                    return mid;
                }else {
                    return high;
                }
            }
        }
        return -1;
    }


    /**
     * 获取fibonacci数组
     */
    public static int[] fibonacci(){
        int[] arr = new int[20];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i-1] +arr[i-2];
        }
        return arr;
    }
}
