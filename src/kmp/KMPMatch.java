package kmp;

/**
 * Created by LiuLiHao on 2019/7/7 0007 下午 09:31
 * @author : LiuLiHao
 * 描述： kmp匹配
 */
public class KMPMatch {

    public static void main(String[] args) {

        String s1 = "hello java";
        String s2 = "java";
        int[] next = kmpIndex(s2);
        System.out.println(indexOf(s1,s2,next));

    }

    /**
     * kmp查找
     * @param s1
     * @param s2
     * @return
     */
    private static int indexOf(String s1, String s2,int[] next) {

        int j=0;
        for (int i = 0; i < s1.length(); i++) {
            //kmp
            while (s1.charAt(i)!=s2.charAt(j) && j>0 ){
                j = next[j-1];
            }
            if (s1.charAt(i)==s2.charAt(j)){
                j++;
            }
            if (j==s2.length()){
                return i-j+1;
            }
        }
        return -1;
    }

    /**
     * 计算字符串next数组
     * @param sub
     * @return
     */
    private static int[] kmpIndex(String sub){
        int[] result = new int[sub.length()];

        //第一个字母位置为0
        result[0] = 0;
        int j=0;
        for (int i = 1; i < sub.length(); i++) {
            //kmp 不断往回找
            while (sub.charAt(i)!=sub.charAt(j) && j>0 ){
                j = result[j-1];
            }
            if (sub.charAt(i)==sub.charAt(j)){
                j++;
            }
            result[i] = j;
        }
        return result;
    }


}
