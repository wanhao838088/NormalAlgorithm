package graph;

import java.util.*;

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

    /**
     * 点是否被访问过
     */
    private boolean[] visited;

    public GraphDemo(int n) {
        edges = new int[n][n];
        visited = new boolean[n];
        points = new ArrayList<>(n);
    }

    /**
     * 深度优先遍历
     */
    public void dfs(){
        //对每个点进行分别遍历
        for (int i = 0; i < points.size(); i++) {
            if(!visited[i]){
                dfs(visited,i);
            }
        }
    }

    /**
     * 光度优先遍历
     */
    public void bfs(){
        //对每个点进行分别遍历
        for (int i = 0; i < points.size(); i++) {
            if(!visited[i]){
                bfs(visited,i);
            }
        }
    }


    private void bfs(boolean[] visited, int i) {
        //当前下标
        int cur ,w;
        Queue<Integer> queue =new LinkedList<>();
        System.out.print(points.get(i)+"->");

        visited[i] = true;
        queue.add(i);

        while (!queue.isEmpty()){
            cur = queue.poll();

            w = getNeighbor(cur);

            while (w!=-1){
                //没有被访问
                if (!visited[cur]){
                    System.out.print(points.get(w)+"->");
                    queue.add(w);
                    visited[w] = true;
                }
                w = getNextNeighbor(i,w);
            }

        }
    }

    private void dfs(boolean[] visited, int i) {
        System.out.print(points.get(i) + "->");
        //已访问
        visited[i] = true;
        int w = getNeighbor(i);
        while (w!=-1){
            //并且没有被访问过
            if(!visited[w]){
                dfs(visited,w);
            }
            //移动点
            w = getNextNeighbor(i,w);
        }
    }

    /**
     * 获取下一个临接点
     * @param i
     * @return
     */
    private int getNeighbor(int i){
        for (int j = 0; j < points.size(); j++) {
            if(edges[i][j]>0){
                return j;
            }
        }
        return -1;
    }

    /**
     * 获取下一个的下一个临接点
     * @param i
     * @return
     */
    private int getNextNeighbor(int i,int j){
        for (int k = j+1; k < points.size(); k++) {
            if(edges[i][k]>0){
                return k;
            }
        }
        return -1;
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
