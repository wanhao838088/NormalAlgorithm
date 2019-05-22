package find;

/**
 * Created by LiuLiHao on 2019/5/21 0021 下午 08:09
 * @author : LiuLiHao
 * 描述：并查集
 */
public class QuickUnion {
    private int[] parent;
    int count;


    public QuickUnion(int count) {
        this.count = count;
        parent = new int[count];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    /**
     * 查找元素
     * @param position
     * @return
     */
    int find(int position){
        if (parent.length<position){
            throw new RuntimeException("下标越界");
        }
        //查找指向的父元素
        while (position!=parent[position]){
            position = parent[position];
        }
        return position;
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

    /**
     * 连接元素 把一个元素指向另一个元素的根
     * @param p
     * @param q
     */
    void union(int p,int q){
        int pId = find(p);
        int qId = find(q);
        if (pId==qId){
            return;
        }
        //合并
        parent[pId] = qId;
    }
}
