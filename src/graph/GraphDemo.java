package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by LiuLiHao on 2019/7/5 0005 下午 10:14
 * @author : LiuLiHao
 * 描述：图测试
 */
public class GraphDemo {
    /**
     * 边
     */
    private int[][] edges;
    /**
     * 边的数量
     */
    private int edgeCount;
    /**
     * 点
     */
    private List<String> points ;

    public GraphDemo(int n) {
        edges = new int[n][n];
        points = new ArrayList<>(n);
    }

    /**
     * 点的个数
     * @return
     */
    public int getPointCount(){
        return points.size();
    }

    /**
     * 获取指定位置权值
     * @param i
     * @param j
     * @return
     */
    public int getWeight(int i,int j){
        return edges[i][j];
    }

    /**
     * 添加一个点
     * @param p
     */
    public void addPoint(String p){
        points.add(p);
    }

    /**
     * 添加一个边
     * @param i
     * @param j
     * @param weight
     */
    public void addEdge(int i,int j,int weight){
        edges[i][j] = weight;
        edges[j][i] = weight;
        edgeCount++;
    }

    /**
     * 打印数组
     */
    public void showGraph(){
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }

    }
}
