package find;

/**
 * Created by LiuLiHao on 2019/5/21 0021 下午 08:09
 * @author : LiuLiHao
 * 描述：并查集
 */
public class UnionFind {
    private int[] arr;
    int count;


    public UnionFind(int count) {
        this.count = count;
        arr = new int[count];
    }

    /**
     * 查找元素
     * @param position
     * @return
     */
    int find(int position){
        if (arr.length<position){
            throw new RuntimeException("下班越界");
        }
        return arr[position];
    }

    /**
     * 是否连接
     * @param p
     * @param q
     * @return
     */
    boolean isConnnected(int p,int q){
        return find(p)==find(q);
    }

    void union(int p,int q){
        int pId = find(p);
        int qId = find(q);
        if (pId==qId){
            return;
        }
        //合并
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==pId){
                arr[i] = qId;
            }
        }
    }
}
