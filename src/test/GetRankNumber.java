package test;

/**
 * Created by LiuLiHao on 2019/7/11 0011 下午 04:12
 * @author : LiuLiHao
 * 描述：获取指定排名的数字
 *
 */
public class GetRankNumber {
    public static void main(String[] args) {

        int[] nums = new int[100];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) (Math.random()*nums.length);
        }
        //求第20的数字
        int num = getRank(nums,50);
        System.out.println(num);
    }

    private static int getRank(int[] nums, int i) {
        if (i<0 || i>nums.length){
            throw new RuntimeException("参数异常");
        }
        return getRank(nums,0,nums.length-1,i);
    }

    /**
     * 获取指定排名数字
     * @param nums
     * @param start
     * @param end
     * @param index
     * @return
     */
    private static int getRank(int[] nums, int start, int end, int index) {
        if (start==end){
            return nums[start];
        }

        //快速排序一次
        int p = partion(nums,start,end);
        if (p==index){
            return nums[p];
        }else if(index<p){
            //往左找
            return getRank(nums,start,p-1,index);
        }else {
            return getRank(nums,p+1,end,index);
        }
    }

    private static int partion(int[] nums, int start, int end) {
        //随机交换一下位置
        swap(nums,start,(int) (Math.random()*(end-start+1)+start));

        int j = start;

        int val = nums[start];

        for (int i = start+1; i <=end ; i++) {
            if (nums[i] < val){
                j++;
                swap(nums,i,j);
            }
        }
        swap(nums,j,start);

        return j;
    }

    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
