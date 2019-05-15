package heap;

/**
 * Created by LiuLiHao on 2019/5/15 0015 上午 11:43
 * @author : LiuLiHao
 * 描述：测试堆
 */
public class HeapTest {

    public static void main(String[] args) {
        MaxHeap<Integer> heap = new MaxHeap<>();

        heap.insert(110);
        heap.insert(200);
        heap.insert(90);

        heap.print();
        System.out.println(heap.size());
    }
}
