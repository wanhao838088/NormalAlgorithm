package huffmancode;

import java.util.*;

/**
 * Created by LiuLiHao on 2019/6/29 0029 下午 05:33
 * @author : LiuLiHao
 * 描述：哈夫曼编码
 */
public class HuffmanCode {

    private static Map<Byte,String> dict = new HashMap<>();
    private static StringBuilder sb=new StringBuilder();


    public static void main(String[] args) {

        String str = "i like like like java do you like a java";
        byte[] bytes = str.getBytes();
        //System.out.println(Arrays.toString(zip(bytes)));
        byte[] zip = zip(bytes);
        byte[] unZip = unZip(zip);
        System.out.println(new String(unZip));
    }

    /**
     * 封装后的压缩方法
     * @param org
     * @return
     */
    private static byte[] zip(byte[] org){
        List<Node> nodes = getNodes(org);
        Node huffmanTree = getHuffmanTree(nodes);
        getCodes(huffmanTree);
        return zipData(org);
    }

    /**
     * 根据给的压缩数据 进行解压
     * @param zips 压缩的byte数据
     */
    private static byte[] unZip(byte[] zips){
        //先把数组转成 二进制的字符串
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < zips.length; i++) {
            if (i==zips.length-1){
                //最后一个字节不需要补位
                sb.append(byte2BitString(false,zips[i]));
            }else {
                sb.append(byte2BitString(true,zips[i]));
            }
        }
        //查询字典 把二进制字符串转成 byte数组
        HashMap<String, Byte> curMap = new HashMap<>();

        for (Map.Entry<Byte, String> entry : dict.entrySet()) {
            curMap.put(entry.getValue(),entry.getKey());
        }

        List<Byte> list = new LinkedList<>();

        for (int i = 0; i < sb.length(); ) {
            int count = 1;
            boolean flag =true;
            while (flag){
                String sub = sb.substring(i, i + count);
                //查找字典
                Byte aByte = curMap.get(sub);
                if (aByte==null){
                    count++;
                }else {
                    //找到了
                    list.add(aByte);
                    flag = false;
                }
            }
            i+=count;
        }
        //构成字节数组
        byte[] bys = new byte[list.size()];
        for (int i = 0; i < bys.length; i++) {
            bys[i] = list.get(i);
        }
        return bys;
    }

    /**
     * 把byte变成 8位字符串
     * @param flag 是否需要补位
     * @param b
     * @return
     */
    private static String byte2BitString(boolean flag,byte b){
        int temp = b;
        if (flag){
            //补位
            temp|=256;
        }

        String s = Integer.toBinaryString(temp);

        if (!flag){
            return s;
        }
        //返回末尾8位
        return s.substring(s.length()-8);
    }

    /**
     * 压缩数据
     * @param org
     * @return
     */
    private static byte[] zipData(byte[] org){
        //存放编码后的字符串
        StringBuilder temp = new StringBuilder();

        for (byte b : org) {
            temp.append(dict.get(b));
        }
        //转成结果的数组
        int len = 0;
        len = (temp.length()+7) /8;

        byte[] result = new byte[len];
        int index = 0;
        //赋值
        for (int i = 0; i < temp.length(); i+=8) {
            String sub = null;
            if (i+8>temp.length()){
                sub = temp.substring(i);
            }else {
                sub = temp.substring(i, i + 8);
            }
            int value = Integer.valueOf(sub, 2);
            //转成byte
            result[index] = (byte)value;
            index++;
        }
        return result;
    }
    /**
     * 重载一下
     * @param node
     */
    private static void getCodes(Node node){
        if (node!=null){
            getCodes(node.left,"0",sb);
            getCodes(node.right,"1",sb);
        }
    }
    /**
     * 获取对应的编码表
     * @param node
     * @param code 往左是 0  往右是 1
     * @param sb
     */
    private static void getCodes(Node node,String code,StringBuilder sb){
        if (node==null){
            return;
        }
        StringBuilder sb2 = new StringBuilder(sb);
        sb2.append(code);
        if(node.val==null){
            //递归
            getCodes(node.left,"0",sb2);
            getCodes(node.right,"1",sb2);
        }else {
            //设置对应的编码
            dict.put(node.val,sb2.toString());
        }
    }

    /**
     * 构建成哈夫曼树
     * @param nodes
     * @return
     */
    private static Node getHuffmanTree(List<Node> nodes ){
        while (nodes.size()>1){
            Collections.sort(nodes);
            Node left = nodes.get(0);
            Node right = nodes.get(1);
            //构建父节点
            Node parent = new Node(null,left.weight+right.weight);
            parent.left = left;
            parent.right = right;
            //删除
            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    /**
     * 变成list<node>
     * @param bytes
     * @return
     */
    private static List<Node> getNodes(byte[] bytes){
        List<Node> list = new LinkedList<>();

        Map<Byte,Integer> map = new HashMap<>();

        //构建map 的键值对
        for (byte b : bytes) {
            Integer defVal = map.get(b);
            if (defVal==null){
                map.put(b,1);
            }else {
                map.put(b,defVal+1);
            }
        }
        //构建成List
        for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
            Byte key = entry.getKey();
            Integer value = entry.getValue();
            list.add(new Node(key,value));
        }
        return list;
    }
}


class Node implements Comparable<Node>{
    Byte val;
    Integer weight;
    Node left;
    Node right;

    public Node(Byte val, int weight) {
        this.val = val;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", weight=" + weight +
                '}';
    }

    /**
     * 前序遍历
     * @param node
     */
    public void preOrder(Node node){
        System.out.println(node);
        if (node.left!=null){
            preOrder(node.left);
        }
        if (node.right!=null){
            preOrder(node.right);
        }
    }

    /**
     * 升序排列
     * @param o
     * @return
     */
    @Override
    public int compareTo(Node o) {
        return this.weight-o.weight;
    }
}
