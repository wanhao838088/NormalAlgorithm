package stack;

/**
 * Created by LiuLiHao on 2019/6/18 0018 下午 02:34
 *
 * @author : LiuLiHao
 * 描述：
 */
public class TestCalc {

    public static void main(String[] args) {

        int x=2,y=1,t;

        double sum = 0;
        for(int i=1;i<=20;i++){
            sum+= 1.0*x/y;
            t = y;
            y = x;
            x = t+y;
        }
        System.out.println(sum);
    }
}
