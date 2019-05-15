package sort;

import java.util.Random;

/**
 * Created by LiuLiHao on 2019/5/13 0013 下午 03:07
 * @author : LiuLiHao
 * 描述：测试排序辅助类
 */
public class SortTestHelper {

    /**
     * 随机生成数组
     * @param count 数组大小
     * @return 数组
     */
    public static int[] makeRandomArray(int count){
        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = (int) (Math.random()*count);
        }
        return arr;
    }

    /**
     * 随机有序数组
     * @param count 数组大小
     * @return 数组
     */
    public static int[] makeSortArray(int count){
        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = i;
        }
        return arr;
    }


    /**
     * 指定范围有序重复数组
     * 例如 1,1,1,1,1,1,1,2,2,2,2,2,3,3,3,3
     * @param count 数组大小
     * @param start 开始范围
     * @param end 结束范围
     * @return 数组
     */
    public static int[] makeRepeatArray(int count,int start,int end){
        int[] arr = new int[count];
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            arr[i] = random.nextInt(end-start)+start;
        }
        return arr;
    }

    /**
     * 打乱数组元素顺序
     * @param arr
     */
    public static void shuffleArray(Object[] arr){
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int j = (int) ((Math.random()*(n-i)))+i;
            //交换位置
            Object temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
