package test;

import java.util.Arrays;

/**
 * Created by LiuLiHao on 2019/7/3 0003 下午 03:57
 * @author : LiuLiHao
 * 描述：
 * 1 亿个数字里里面找最小的 10 个
 */
public class BiilonTest {

    public static void main(String[] args) {
        //产生随机数
        int[] arr = new int[100000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random()*arr.length);
        }
        //开始时间
        long start = System.currentTimeMillis();
        int[] ten = getTopTen(arr);
        //结束时间
        long end = System.currentTimeMillis();
        System.out.println("耗时: " + 1.0*(end-start)/1000 );
        //最小的10个数
        System.out.println(Arrays.toString(ten));
    }

    /**
     * 获取最小的10个数字
     * @param arr
     * @return
     */
    private static int[] getTopTen(int[] arr){
        int[] result = new int[10];
        //初始化10个数 为最大
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.MAX_VALUE;
        }
        //循环查找
        for (int i = 0; i < arr.length; i++) {
            compare(result,arr[i]);
        }
        return result;
    }

    private static void compare(int[] arr,int i){
        for (int j = arr.length-1; j >0 ; j--) {
            if (i<arr[j]){
                arr[j] = i;
                //始终保持升序
                Arrays.sort(arr);
                break;
            }else {
                break;
            }
        }
    }

}
