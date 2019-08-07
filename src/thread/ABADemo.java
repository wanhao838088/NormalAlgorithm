package thread;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * Created by LiuLiHao on 2019/8/7 0007 下午 03:15
 * @author : LiuLiHao
 * 描述：ABA问题测试和解决
 */
public class ABADemo {

    public static void main(String[] args) {
        //普通原子引用 和 带时间戳的原子引用
        AtomicReference<String> atomicReference = new AtomicReference<>("a");
        //1
        System.out.println(atomicReference.compareAndSet("a", "b"));
        //2
        System.out.println(atomicReference.compareAndSet("b", "a"));
        //3
        System.out.println(atomicReference.compareAndSet("a", "b"));

        //带时间戳
        AtomicStampedReference<String> stampedReference =
                new AtomicStampedReference<>("a",1);

        int stamp = stampedReference.getStamp();
        System.out.println("版本  "+ stamp);
        System.out.println(stampedReference.compareAndSet("a", "b", 1, 2));

        //第二次修改
        System.out.println(stampedReference.compareAndSet("b", "a", 1, 2));

    }
}
