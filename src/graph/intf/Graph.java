package graph.intf;

/**
 * Created by LiuLiHao on 2019/7/14 0014 上午 10:08
 * @author : LiuLiHao
 * 描述：图接口
 */
public interface Graph {

    public int V();
    public int E();

    /**
     * 添加边
     * @param v
     * @param w
     */
    public void addEdge( int v , int w );

    /**
     * 是否包含这个边
     * @param v
     * @param w
     * @return
     */
    boolean hasEdge( int v , int w );

    /**
     * 打印图
     */
    void show();

    /**
     * 遍历
     * @param v
     * @return
     */
    public Iterable<Integer> iterable(int v);
}
