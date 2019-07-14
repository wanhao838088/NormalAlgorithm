package graph.test;

import graph.Components;
import graph.DenseGraph;
import graph.ReadGraph;
import graph.SparseGraph;
import org.junit.jupiter.api.Test;

/**
 * Created by LiuLiHao on 2019/7/14 0014 上午 10:24
 * @author : LiuLiHao
 * 描述：测试图读取文件
 */
public class GraphReadTest {

    @Test
    public void test1(){
        DenseGraph denseGraph = new DenseGraph(13,false);
        ReadGraph readGraph = new ReadGraph();
        readGraph.readFile(denseGraph,"testG1.txt");

        //输出图信息
        denseGraph.show();
    }

    @Test
    public void test2(){
        SparseGraph graph = new SparseGraph(13, false);
        ReadGraph readGraph = new ReadGraph();
        readGraph.readFile(graph,"testG1.txt");

        //输出图信息
        graph.show();

        Components components = new Components(graph);
        int count = components.count();
        System.out.println(count);
    }
}
