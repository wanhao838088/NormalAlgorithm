package graph;

import graph.intf.Graph;

/**
 * Created by LiuLiHao on 2019/7/14 0014 上午 10:52
 * @author : LiuLiHao
 * 描述：求图的连通分量
 */
public class Components {

    Graph graph;
    /**
     * 记录dfs的过程中节点是否被访问
     */
    private boolean[] visited;
    /**
     * 记录联通分量个数
     */
    private int ccount;
    /**
     * 每个节点所对应的联通分量标记
     */
    private int[] id;

    public Components(Graph graph) {
        this.graph = graph;
        visited = new boolean[graph.V()];
        //设置-1
        id = new int[graph.V()];
        for (int i = 0; i < graph.V(); i++) {
            id[i] = -1;
        }
        //求连通分量
        for (int i = 0; i < graph.V(); i++) {
            if (!visited[i]){
                dfs(i);
                ccount++;
            }
        }
    }

    /**
     * 对指定的点进行深度遍历
     * @param p
     */
    private void dfs(int p) {
        visited[p] = true;
        id[p] = ccount;
        for (Integer temp : graph.iterable(p)) {
            if (!visited[temp]){
                dfs(temp);
            }
        }

    }

    public int count(){
        return ccount;
    }
}
