package recursion;

/**
 * Created by LiuLiHao on 2019/6/22 0022 下午 08:58
 * @author : LiuLiHao
 * 描述：八皇后
 */
public class Queen8 {

    /**
     * 皇后数量
     */
    private int max = 8;

    private int[] arr = new int[8];

    /**
     * 解的数量
     */
    private static int count = 0;

    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.play(0);

    }

    /**
     * 摆放皇后
     * @param n
     */
    private void play(int n){
        if (n==max){
            //递归结束
            print();
            return;
        }
        for (int i = 0; i < max; i++) {
            arr[n] = i;
            if (judge(n)){
                play(n+1);
            }
        }

    }

    /**
     * 判断是否互相攻击
     * @param n
     * @return
     */
    private boolean judge(int n){
        for (int i = 0; i < n; i++) {
            if (arr[i]==arr[n] || Math.abs(n-i)==Math.abs(arr[n]-arr[i])){
                return false;
            }
        }
        return true;
    }

    /**
     * 输出解
     */
    private void print(){
        count++;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }
}
