package lru;


import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by LiuLiHao on 2019/7/21 0021 下午 05:25
 * @author : LiuLiHao
 * 描述：lru缓存
 */
public class LRUCache<K,V> {

    /**
     * 容量
     */
    private int capacity;
    /**
     * 存放 key value
     */
    private HashMap<K,V> map;
    /**
     * 存放顺序
     */
    private LinkedList<K> list;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        list = new LinkedList<>();
    }

    /**
     * 添加
     * @param key
     * @param value
     */
    public void put(K key,V value){
        V v = map.get(key);
        if (v==null){
            //不存在 直接放进去
            if (map.size()!=capacity){
                //容量没满  直接更新
                map.put(key,value);

                list.add(key);
            }else {
                //容量满了 移除没用的那个  先删除再更新
                K rmK = list.get(0);
                list.remove(rmK);
                map.remove(rmK);

                map.put(key,value);
                list.add(key);
            }
        }else {
            //直接更新
            map.put(key,value);
            list.remove(key);
            list.add(key);
        }
    }

    /**
     * 查询
     * @param key
     * @return
     */
    public V get(K key){
        V v = map.get(key);
        if (v!=null){
            //顺序提前
            list.remove(key);
            list.add(key);
        }
        return v;
    }
}
