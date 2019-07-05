package graph;

import org.junit.jupiter.api.Test;

/**
 * Created by LiuLiHao on 2019/7/5 0005 下午 10:18
 * @author : LiuLiHao
 * 描述：测试图
 */
public class GraphTest {

    @Test
    public void testCreate(){
        GraphDemo graph = new GraphDemo(5);
        String[] points = {"A","B","C","D","E"};
        for (String point : points) {
            graph.addPoint(point);
        }


        //添加边
        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 2, 1);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 1);
        graph.addEdge(1, 4, 1);
        graph.showGraph();
    }
}
