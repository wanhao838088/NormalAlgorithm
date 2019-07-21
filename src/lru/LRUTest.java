package lru;

/**
 * Created by LiuLiHao on 2019/7/21 0021 下午 05:43
 * @author : LiuLiHao
 * 描述：测试
 */
public class LRUTest {

    public static void main(String[] args) {
        LRUCache<Integer, Integer> cache = new LRUCache<>(2);


        cache.put(1, 1);
        cache.put(2, 2);

        // 返回  1
        System.out.println(cache.get(1));

        // 该操作会使得密钥 2 作废
        cache.put(3, 3);

        // 返回 -1 (未找到) 31
        System.out.println(cache.get(2));

        // 该操作会使得密钥 1 作废 43
        cache.put(4, 4);
        System.out.println(cache.get(1));

    }
}
