package tree;

import java.util.Arrays;

/**
 * Created by LiuLiHao on 2019/6/28 0028 上午 08:31
 * @author : LiuLiHao
 * 描述：堆排序
 */
public class HeapSort {

    public static void main(String[] args) {
        int count = 80;

        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = (int) (Math.random()*count);
        }
        long start = System.currentTimeMillis();
        sort(arr);
        long end = System.currentTimeMillis();

        System.out.println(Arrays.toString(arr));

        System.out.println("耗时"+1.0*(end-start)/1000 +"秒");
    }

    private static void sort(int[] arr){
        int len = arr.length;

        //先把数组调成最大堆
        for (int i = len/2-1; i >=0 ; i--) {
            adjust(arr,i,len);
        }

        int temp = 0;
        //逐个排序
        for (int j=len-1; j >0 ; j--) {
            temp = arr[0];
            arr[0] = arr[j];
            arr[j] = temp;
            adjust(arr,0,j);
        }
    }

    /**
     * 把数组调整成最大堆
     * @param arr
     * @param i
     * @param len
     */
    private static void adjust(int[] arr,int i,int len){
        int temp = arr[i];
        for (int j = i*2+1; j < len; j=i*2+1) {
            //判断左右节点哪个大
            if (j+1<len && arr[j+1]>arr[j]){
                j++;
            }

            if (temp<arr[j]){
                //把大的数赋值过去
                arr[i] = arr[j];
                i=j;
            }else {
                break;
            }
        }
        arr[i] = temp;

    }
}
