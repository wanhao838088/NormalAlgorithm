package find;

/**
 * Created by LiuLiHao on 2019/5/22 0022 下午 02:47
 * @author : LiuLiHao
 * 描述：
 */
public class TestUnion {

    public static void main(String[] args) {
        QuickUnion quickUnion = new QuickUnion(10000);
        quickUnion.union(1,99);
        quickUnion.union(2,99);
        quickUnion.union(3,99);
        quickUnion.union(5,88);
        quickUnion.union(5,1);


        System.out.println(quickUnion.isConnected(1,99));
        System.out.println(quickUnion.isConnected(1,88));

    }
}
