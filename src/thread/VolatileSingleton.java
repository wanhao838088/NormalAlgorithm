package thread;

/**
 * Created by LiuLiHao on 2019/8/1 0001 下午 03:20
 * @author : LiuLiHao
 * 描述：单例模式
 */
public class VolatileSingleton {

    private VolatileSingleton(){}

    //禁止指令重排序
    private volatile VolatileSingleton instance = null;

    public VolatileSingleton getInstance(){
        if (instance==null){
            synchronized (VolatileSingleton.class){
                if (instance==null){
                    instance = new VolatileSingleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {

    }
}
