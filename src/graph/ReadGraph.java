package graph;

import graph.intf.Graph;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Scanner;

/**
 * Created by LiuLiHao on 2019/7/14 0014 上午 10:14
 * @author : LiuLiHao
 * 描述：读取文件中的图信息到类
 */
public class ReadGraph {

    private Scanner scanner;

    /**
     * 读取文件中的图信息到类
     * @param graph
     * @param fileName
     */
    public void readFile(Graph graph,String fileName){
        initScanner(fileName);
        //获取点和边数量
        int v = scanner.nextInt();
        assert v==graph.V();
        int e = scanner.nextInt();

        for (int i = 0; i < e; i++) {
            //添加边
            int s1 = scanner.nextInt();
            int s2 = scanner.nextInt();
            graph.addEdge(s1,s2);
        }
    }

    private void initScanner(String fileName) {

        try {
            FileInputStream fis = new FileInputStream(fileName);
            scanner = new Scanner(new BufferedInputStream(fis), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
