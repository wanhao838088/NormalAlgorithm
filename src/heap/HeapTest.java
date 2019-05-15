package heap;

/**
 * Created by LiuLiHao on 2019/5/15 0015 上午 11:43
 * @author : LiuLiHao
 * 描述：测试堆
 */
public class HeapTest {

    public static void main(String[] args) {
        MaxHeap<Integer> heap = new MaxHeap<>();

        for (int i = 0; i < 100; i++) {
            heap.insert((int) (Math.random()*100));
        }

        //取出元素
        while (!heap.isEmpty()){
            System.out.println(heap.get());
        }

        System.out.println(heap.size());
    }
}
