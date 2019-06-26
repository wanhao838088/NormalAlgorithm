package tree;

/**
 * Created by LiuLiHao on 2019/6/26 0026 下午 07:33
 * 描述：
 */
public class TestArrBinTree {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        ArrBinTree tree = new ArrBinTree(arr);
        tree.preOrder();
        System.out.println("-------------");
        tree.midOrder();
        System.out.println("-------------");
        tree.postOrder();
    }
}
