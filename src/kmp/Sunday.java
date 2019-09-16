package kmp;

import java.util.Arrays;

/**
 * Created by LiuLiHao on 2019/9/16 0016 下午 04:36
 * @author : LiuLiHao
 * 描述：
 */
public class Sunday {

    public static void main(String[] args) {
        String str = "abadfsf abcaaa";
        String pattern = "abc";
        int i = sunday(str,pattern);
        System.out.println(i);
    }

    private static int sunday(String haystack, String needle) {
        int[] next = next(needle);
        //求位置
        int len = haystack.length();
        for (int i = 0; i < len;) {

            int j=0;
            for( ;j<needle.length()&& i+j<haystack.length();j++){
                //不匹配 直接跳出
                if (needle.charAt(j)!=haystack.charAt(i+j)){
                    break;
                }
            }

            //全部匹配了
            if (j==needle.length()){
                return i;
            }
            //长度不够
            if (i+needle.length()>=haystack.length()){
                return -1;
            }
            i+= needle.length() - next[haystack.charAt(i+needle.length())];
        }
        return -1;
    }

    private static int[] next(String pattern) {
        char[] chs = pattern.toCharArray();
        //可能出现的字符数量
        int[] result = new int[65536];


        Arrays.fill(result,-1);
        for (int i = 0; i < chs.length; i++) {
            result[chs[i]] = i;
        }
        return result;
    }
}
