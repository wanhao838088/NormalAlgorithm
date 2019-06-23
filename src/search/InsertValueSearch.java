package search;

/**
 * Created by LiuLiHao on 2019/6/23 0023 下午 04:54
 * @author : LiuLiHao
 * 描述：插值查找
 */
public class InsertValueSearch {

    public static void main(String[] args) {
        int[] arr  ={1,2,3,4,5,6,7};
        int search = search(arr, 5,0,arr.length-1);
        System.out.println(search);
    }

    public static int search(int[] arr, int val, int left, int right) {
        //结束条件
        if (left>right || val<arr[0] || val>arr[arr.length-1]){
            return -1;
        }
        //求Mid
        int mid = left + (right-left) * (val-arr[left])/(arr[right] -arr[left]);
        int temp = arr[mid];
        if (val==temp){
            return mid;
        }else  if(val<temp){
            return search(arr,val,left,mid-1);
        }else {
            return search(arr,val,mid+1,right);
        }
    }
}
