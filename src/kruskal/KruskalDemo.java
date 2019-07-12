package kruskal;

/**
 * Created by LiuLiHao on 2019/7/11 0011 下午 07:45
 * @author : LiuLiHao
 * 描述：克鲁斯卡尔最小生成树
 */
public class KruskalDemo {
    /**
     * 边的个数
     */
    private int edgeNum;

    /**
     * 顶点数组
     */
    private char[] vertexs;
    /**
     * 邻接矩阵
     */
    private int[][] matrix;

    /**
     * 使用 INF 表示两个顶点不能连通
     */
    private static final int INF = Integer.MAX_VALUE;

    public KruskalDemo(char[] vertexs, int[][] matrix) {
        int len = vertexs.length;

        this.vertexs = vertexs;
        this.matrix = matrix;
        //统计边的条数
        for (int i = 0; i < len; i++) {
            //从i+1自动过滤出自身
            for (int j = i+1; j < len; j++) {
                if (matrix[i][j]!=INF){
                    edgeNum++;
                }
            }
        }
    }


    /**
     * 计算最小生成树
     */
    public void kruskal(){

        EData[] edges = getEdges();
        //对边进行排序
        sortEdges(edges);
        //存放最小生成树
        EData[] result = new EData[edgeNum];

        int[] ends = new int[edgeNum];
        int index = 0;
        //对所有边进行遍历
        for (int i = 0; i < edges.length; i++) {
            EData current = edges[i];

            //判断是否形成回环
            int p1 = getPosition(current.start);
            int p2 = getPosition(current.end);
            int e1 = getEndPoint(ends, p1);
            int e2 = getEndPoint(ends, p2);
            //终点不同才连接
            if (e1!=e2){
                result[index++] = current;
                //更新终点
                ends[p1] = p2;
            }

        }

        for (int i = 0; i < result.length; i++) {
            if (result[i]!=null){
                System.out.println(result[i]);
            }
        }
    }

    /**
     * 获取一个点的终点
     *
     * @param ends
     * @param p1
     * @return
     */
    private int getEndPoint(int[] ends, int p1) {
        while (ends[p1]!=0){
            p1 = ends[p1];
        }
        return p1;
    }

    /**
     * 获取对应的顶点的下标
     * @param ch
     * @return
     */
    public int getPosition(char ch){
        for (int i = 0; i < vertexs.length; i++) {
            if (vertexs[i]==ch){
                return i;
            }
        }
        return -1;
    }
    /**
     * 获取所有的边
     * @return
     */
    public EData[] getEdges(){
        EData[] result = new EData[edgeNum];

        int index = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i+1; j < matrix[i].length; j++) {
                if (matrix[i][j]!=INF){
                    //创建边
                    EData eData = new EData(vertexs[i],vertexs[j],matrix[i][j]);
                    result[index++] = eData;
                }
            }
        }
        return result;
    }

    /**
     * 功能：对边进行排序处理, 冒泡排序
     * @param edges 边的集合
     */
    private void sortEdges(EData[] edges) {
        for(int i = 0; i < edges.length - 1; i++) {
            for(int j = 0; j < edges.length - 1 - i; j++) {
                if(edges[j].weight > edges[j+1].weight) {
                    //交换
                    EData tmp = edges[j];
                    edges[j] = edges[j+1];
                    edges[j+1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        //克鲁斯卡尔算法的邻接矩阵
        int[][] matrix = {
                /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
                /*A*/ {   0,  12, INF, INF, INF,  16,  14},
                /*B*/ {  12,   0,  10, INF, INF,   7, INF},
                /*C*/ { INF,  10,   0,   3,   5,   6, INF},
                /*D*/ { INF, INF,   3,   0,   4, INF, INF},
                /*E*/ { INF, INF,   5,   4,   0,   2,   8},
                /*F*/ {  16,   7,   6, INF,   2,   0,   9},
                /*G*/ {  14, INF, INF, INF,   8,   9,   0}};

        KruskalDemo kruskalDemo = new KruskalDemo(vertexs,matrix);

        //一共12条边
        //System.out.println(kruskalDemo.edgeNum);
        kruskalDemo.kruskal();
    }


    /**
     * 创建一个类EData ，它的对象实例就表示一条边
     */
    class EData {
        /**
         * 边的一个点
         */
        char start;
        /**
         * 边的另外一个点
         */
        char end;
        /**
         * 边的权值
         */
        int weight;

        /**
         * 构造器
         * @param start 起点
         * @param end 终点
         * @param weight 权值
         */
        public EData(char start, char end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "EData [<" + start + ", " + end + ">= " + weight + "]";
        }

    }
}
