package search;

/**
 * Created by LiuLiHao on 2019/5/17 0017 下午 08:42
 * @author : LiuLiHao
 * 描述：测试二分查找法
 */
public class TestBinSearch {

    public static void main(String[] args) {
        int[] arr  ={1,2,3,4,5,6,7};
        int search = BinSearch.searchBack(arr, 33,0,arr.length-1);
        System.out.println(search);
    }
}
