package graph;

import graph.intf.Graph;

import java.util.Vector;

/**
 * Created by LiuLiHao on 2019/7/13 0013 下午 09:09
 * @author : LiuLiHao
 * 描述：稠密图
 */
public class DenseGraph implements Graph {
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
    @Override
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
    @Override
    public void addEdge(int i, int j){
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
    @Override
    public boolean hasEdge(int i, int j){
        return data[i][j];
    }

    @Override
    public void show() {
        //打印
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j]){
                    System.out.print(1);
                }else {
                    System.out.print(0);
                }
            }
            System.out.println();
        }
    }

    /**
     * 迭代操作
     * @param index
     * @return
     */
    @Override
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
