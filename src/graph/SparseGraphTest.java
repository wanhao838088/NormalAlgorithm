package graph;

import org.junit.jupiter.api.Test;

/**
 * Created by LiuLiHao on 2019/7/13 0013 下午 10:01
 * @author : LiuLiHao
 * 描述：测试
 */
public class SparseGraphTest {
    @Test
    public void testIterator(){
        SparseGraph graph = new SparseGraph(20, false);

        for (int i = 0; i < 20; i++) {
            int j = (int) (Math.random()*20);
            int k = (int) (Math.random()*20);
            graph.addEdge(j,k);
        }

        for (int i = 0; i < 20; i++) {
            Iterable<Integer> iterable = graph.iterable(i);
            for (Integer integer : iterable) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }
}
