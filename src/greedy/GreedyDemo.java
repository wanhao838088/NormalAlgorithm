package greedy;

import java.util.*;

/**
 * Created by LiuLiHao on 2019/7/9 0009 下午 07:55
 * @author : LiuLiHao
 * 描述：电视站台问题
 *
 */
public class GreedyDemo {

    public static void main(String[] args) {
        //创建广播电台,放入到Map
        HashMap<String,HashSet<String>> broadcasts = new HashMap<>();
        //将各个电台放入到broadcasts
        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");

        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");

        HashSet<String> hashSet3 = new HashSet<>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");


        HashSet<String> hashSet4 = new HashSet<>();
        hashSet4.add("上海");
        hashSet4.add("天津");

        HashSet<String> hashSet5 = new HashSet<>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        //加入到map
        broadcasts.put("K1", hashSet1);
        broadcasts.put("K2", hashSet2);
        broadcasts.put("K3", hashSet3);
        broadcasts.put("K4", hashSet4);
        broadcasts.put("K5", hashSet5);

        //allAreas 存放所有的地区
        HashSet<String> allAreas = new HashSet<>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("深圳");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");


        //覆盖最多的那个站
        String maxKey = "";
        int maxSize = 0;

        List<String> result = new ArrayList<>();

        HashSet<String> temp = new HashSet<>();

        while (allAreas.size()!=0){
            maxKey = "";
            maxSize = 0;

            for (Map.Entry<String, HashSet<String>> entry : broadcasts.entrySet()) {
                String key = entry.getKey();
                temp = entry.getValue();
                //看sub占多少个站
                temp.retainAll(allAreas);
                if(temp.size()>maxSize){
                    maxKey = key;
                    maxSize = temp.size();
                }
            }
            result.add(maxKey);
            //移除
            for (String s : broadcasts.get(maxKey)) {
                allAreas.remove(s);
            }

            broadcasts.remove(maxKey);

        }

        System.out.println(result);
    }
}
