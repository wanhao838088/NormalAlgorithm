package graph;

import java.util.Arrays;

/**
 * Created by LiuLiHao on 2019/7/10 0010 上午 08:33
 * @author : LiuLiHao
 * 描述：普利姆算法
 */
public class PrimDemo {

    public static void main(String[] args) {
        //测试看看图是否创建ok
        char[] data = new char[]{'A','B','C','D','E','F','G'};
        int verxs = data.length;
        //邻接矩阵的关系使用二维数组表示,10000这个大数，表示两个点不联通
        int[][] weight=new int[][]{
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000},};
        //创建MGraph对象
        MGraph graph = new MGraph(verxs);
        //创建一个MinTree对象
        MinTree minTree = new MinTree();
        minTree.createGraph(graph,verxs,data,weight);
        //minTree.showGraph(graph);

        //调用
        minTree.prim(graph,0);
    }

    /**
     * 最小生成树
     */
    static class MinTree{
        /**
         * 创建图
         * @param graph
         * @param count
         * @param data
         * @param weight
         */
        public void createGraph( MGraph graph,int count,char[] data,int[][] weight){
            for (int i = 0; i < count; i++) {
                graph.data[i] = data[i];
                for (int j = 0; j < count; j++) {
                    graph.weight[i][j] = weight[i][j];
                }
            }
        }


        /**
         * 普利姆
         * @param graph
         * @param start
         */
        public void prim(MGraph graph,int start){
            //首先标记起点为已经访问
            int[] visited = new int[graph.count];
            visited[start] = 1;
            int count = graph.count;

            int minWeight = 10000;
            //行 列 最小标记
            int x=-1,y=-1;

            for (int i = 1; i <count; i++) {

                for (int j = 0; j < count; j++) {
                    for (int k = 0; k < count; k++) {
                        if (visited[j]==1 && visited[k]==0 && graph.weight[j][k] <minWeight){
                            //更新最小值
                            minWeight = graph.weight[j][k];
                            x = j;
                            y = k;
                        }
                    }
                }
                //找到最小的了 输出
                System.out.println("边 ："+graph.data[x]+" " + graph.data[y] + "权值为 "+ minWeight);
                minWeight = 10000;
                visited[y] = 1;
            }
        }

        /**
         * 显示图的邻接矩阵
         * @param graph
         */
        public void showGraph(MGraph graph) {
            for(int[] link: graph.weight) {
                System.out.println(Arrays.toString(link));
            }
        }

    }

    static class MGraph{
        /**
         * 点的个数
         */
        int count;
        /**
         * 点的名称
         */
        char[] data;
        /**
         * 权重集合
         */
        int[][] weight;

        public MGraph(int count) {
            this.count = count;
            this.data = new char[count];
            this.weight = new int[count][count];
        }
    }
}
