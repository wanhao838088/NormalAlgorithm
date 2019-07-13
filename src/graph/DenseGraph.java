package graph;

import java.util.Vector;

/**
 * Created by LiuLiHao on 2019/7/13 0013 下午 09:09
 * @author : LiuLiHao
 * 描述：稠密图
 */
public class DenseGraph {
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
    private boolean[][] data;

    /**
     * 初始化
     * @param n
     * @param isDirected
     */
    public DenseGraph(int n,boolean isDirected) {
        this.n = n;
        this.isDirected = isDirected;
        data = new boolean[n][n];
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
        data[i][j] = true;
        if (!isDirected){
            data[j][i] = true;
        }
        m++;
    }

    /**
     * 是否连通
     * @param i
     * @param j
     * @return
     */
    public boolean hasEdge(int i,int j){
        return data[i][j];
    }

    /**
     * 迭代操作
     * @param index
     * @return
     */
    public Iterable<Integer> iterable(int index){
        assert index>=0 && index<n;
        Vector<Integer> result = new Vector<>();

        for (int i = 0; i < n; i++) {
            if (data[index][i]){
                result.add(i);
            }
        }
        return result;
    }
}
