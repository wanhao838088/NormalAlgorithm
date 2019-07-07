package recursion;

/**
 * Created by LiuLiHao on 2019/7/7 0007 上午 10:09
 * @author : LiuLiHao
 * 描述：汉诺塔
 *
 */
public class HanoiTower {

    public static void main(String[] args) {

        solution(2,'A','B','C');
    }

    /**
     * 步骤求解
     * @param n
     * @param a
     * @param b
     * @param c
     */
    private static void solution(int n,char a,char b,char c){
        if (n==1){
            System.out.println("把 第" + n +"个盘子,"+a+"到"+c);
        }else {
            //大于等于2  把a的移动到b
            solution(n-1,a,c,b);
            System.out.println("把 第" + n +"个盘子,"+a+"到"+c);
            solution(n-1,b,a,c);
        }
    }
}
