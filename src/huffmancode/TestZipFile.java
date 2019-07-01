package huffmancode;

import org.junit.jupiter.api.Test;

/**
 * Created by LiuLiHao on 2019/6/30 0030 下午 03:33
 * @author : LiuLiHao
 * 描述： 测试压缩文件
 */
public class TestZipFile {

    @Test
    public void testZip(){
        String in = "c:/shouchi_zhengmian1.jpg";
        String out = "c:/out.zip";
        HuffmanCode.zipFile(in,out);
        System.out.println("压缩完成");
    }
    @Test
    public void testUnZip(){
        String in = "c:/out.zip";
        String out = "c:/unzip.jpg";
        HuffmanCode.unZipFile(in,out);
        System.out.println("解压缩完成");
    }
}
