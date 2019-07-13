package graph;

import java.util.Vector;

/**
 * Created by LiuLiHao on 2019/7/13 0013 下午 09:20
 * @author : LiuLiHao
 * 描述：稀疏图
 */
public class SparseGraph {
    /**
     * 点数量
     */
    private int n;
    /**
     * 边数量
     */
    private int m;

    /**
     * 是否是有向图
     */
    private boolean isDirected;

    /**
     * 点与点之间的连接情况
     */
    private Vector<Integer>[] data;

    public SparseGraph(int n, boolean isDirected) {
        this.n = n;
        this.isDirected = isDirected;
        data = new Vector[n];
        //初始化没有边
        for (int i = 0; i < n; i++) {
            data[i] = new Vector<>();
        }
    }

    /**
     * 返回节点个数
     * @return
     */
    public int V(){ return n;}

    /**
     * 返回边的个数
     * @return
     */
    public int E(){ return m;}

    /**
     * 添加一个边
     * @param i
     * @param j
     */
    public void addEdge(int i,int j){
        assert i>=0 && i<n;
        assert j>=0 && j<n;

        if (hasEdge(i,j)){
            return;
        }
        data[i].add(j);

        if (i!=j &&  !isDirected){
            data[j].add(i);
        }
        m++;
    }

    /**
     * 是否有这个边
     * @param i
     * @param j
     * @return
     */
    private boolean hasEdge(int i, int j) {
        for (int k = 0; k < data[i].size(); k++) {
            Integer temp = data[i].get(k);
            if (temp==j){
                return true;
            }
        }
        return false;
    }

    /**
     * 迭代操作
     * @param index
     * @return
     */
    public Iterable<Integer> iterable(int index){
        assert index>=0 && index<n;

        return data[index];
    }
}
