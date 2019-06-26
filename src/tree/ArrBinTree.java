package tree;

/**
 * Created by LiuLiHao on 2019/6/26 0026 下午 07:30
 * @author : LiuLiHao
 * 描述：使用树的方式遍历数组
 */
public class ArrBinTree {
    private int[] arr;

    public ArrBinTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder(){
        preOrder(0);
    }
    /**
     * 前序遍历
     * @param n
     */
    public void preOrder(int n){
        if (arr==null || arr.length==0){
            System.out.println("数组空");
            return;
        }
        System.out.println(arr[n]);
        //左节点
        int left = 2*n+1;
        if (left<arr.length){
            preOrder(left);
        }
        int right = 2*n+2;
        if (left<arr.length){
            preOrder(right);
        }
    }


    public void midOrder(){
        midOrder(0);
    }
    /**
     * 前序遍历
     * @param n
     */
    public void midOrder(int n){
        if (arr==null || arr.length==0){
            System.out.println("数组空");
            return;
        }
        //左节点
        int left = 2*n+1;
        if (left<arr.length){
            preOrder(left);
        }
        System.out.println(arr[n]);
        int right = 2*n+2;
        if (left<arr.length){
            preOrder(right);
        }
    }

    public void postOrder(){
        postOrder(0);
    }
    /**
     * 前序遍历
     * @param n
     */
    public void postOrder(int n){
        if (arr==null || arr.length==0){
            System.out.println("数组空");
            return;
        }
        //左节点
        int left = 2*n+1;
        if (left<arr.length){
            preOrder(left);
        }
        int right = 2*n+2;
        if (left<arr.length){
            preOrder(right);
        }
        System.out.println(arr[n]);
    }
}
