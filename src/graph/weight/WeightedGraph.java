package graph.weight;

import graph.Edge;

/**
 * Created by LiuLiHao on 2019/7/14 0014 下午 05:25
 * @author : LiuLiHao
 * 描述：有权图
 */
public interface WeightedGraph<Weight extends Number & Comparable> {
    public int V();
    public int E();
    public void addEdge(Edge<Weight> e);
    boolean hasEdge( int v , int w );
    void show();
    public Iterable<Edge<Weight>> adj(int v);
}
