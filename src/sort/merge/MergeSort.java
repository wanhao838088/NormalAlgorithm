package sort.merge;

/**
 * Created by LiuLiHao on 2019/5/13 0013 下午 03:03
 * @author : LiuLiHao
 * 描述：归并排序
 */
public class MergeSort {

    public static void mergeSort(int[] arr){
        mergeSort(arr,0,arr.length-1);
    }

    private static void mergeSort(int[] arr,int left,int right){
        if (left>=right){
            return;
        }
        int mid = (left+right)/2;
        mergeSort(arr,left,mid);
        mergeSort(arr,mid+1,right);
        //如果有序 就不交换
        if (arr[mid]>arr[mid+1]){
            merge(arr,left,mid,right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right-left+1];
        for (int i = left; i <=right ; i++) {
            help[i-left] = arr[i];
        }
        int i=left,j=mid+1;

        for (int k = left; k <=right ; k++) {
            if(i>mid){
                arr[k] = help[j-left];
                j++;
            }else if(j>right){
                arr[k] = help[i-left];
                i++;
            }else if (help[i-left]<help[j-left]){
                arr[k] = help[i-left];
                i++;
            }else{
                arr[k] = help[j-left];
                j++;
            }
        }
    }

}
