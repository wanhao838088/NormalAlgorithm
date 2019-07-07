package kmp;

/**
 * Created by LiuLiHao on 2019/7/7 0007 下午 09:14
 * @author : LiuLiHao
 * 描述：暴力匹配字符串
 */
public class ViolenceMatch {

    public static void main(String[] args) {

        String s1 = "hello java";
        String s2 = "java";

        System.out.println(indexOf(s1,s2));
    }

    /**
     * 查找s2在s1的位置
     * @param s1
     * @param s2
     * @return
     */
    private static int indexOf(String s1,String s2){
        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();
        int s1Len = s1.length();
        int s2Len = s2.length();
        int i = 0,j=0;

        while (i < s1Len && j<s2Len){
            if (chs1[i]==chs2[j]){
                j++;
            }else {
                //从新回去
                i=i-j;
                j=0;
            }
            i++;
        }
        if (j==s2Len){
            return i-j;
        }
        return -1;
    }

}
