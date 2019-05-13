package sort;

/**
 * Created by LiuLiHao on 2019/5/13 0013 下午 03:07
 * @author : LiuLiHao
 * 描述：测试排序辅助类
 */
public class SortTestHelper {

    /**
     * 随机生成数组
     * @param count 数组大小
     * @return
     */
    public static int[] makeRandomArray(int count){
        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = (int) (Math.random()*count);
        }
        return arr;
    }


}
