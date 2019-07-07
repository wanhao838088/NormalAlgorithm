package dynamic;

import java.util.Arrays;

/**
 * Created by LiuLiHao on 2019/7/7 0007 下午 04:48
 * @author : LiuLiHao
 * 描述：背包问题
 */
public class KnapsackProblem {

    public static void main(String[] args) {
        //重量
        int[] w = {1,4,3};
        //价格
        int[] val = {1500,3000,2000};
        //背包容量
        int m = 4;
        int n = val.length;

        //填表的数组
        int[][] v = new int[n+1][m+1];
        //存放结果
        int[][] path = new int[n+1][m+1];

        //先让 第一行 第一列 值为0

        //使用公式填表
        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[0].length; j++) {
                if (w[i - 1] > j) {
                    //重量大于 当前背包容量
                    v[i][j] = v[i - 1][j];
                } else {
                    //找最大值
                    if (v[i - 1][j] >val[i-1]+ v[i - 1][j - w[i-1]] ) {
                        v[i][j] = v[i - 1][j];
                    } else {
                        v[i][j] = val[i-1]+ v[i - 1][j - w[i-1]];
                        path[i][j] = 1;
                    }
                }
            }
        }

        int i=v.length-1;
        int j=v[0].length-1;
        while(i>0&&j>0){
            if(path[i][j] == 1){
                System.out.print("第"+i+"个物品装入 ");
                j -= w[i-1];
            }
            i--;
        }
        System.out.println();


        //打印数组
        for (int[] ints : v) {
            System.out.println(Arrays.toString(ints));
        }

    }
}
