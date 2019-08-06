package thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by LiuLiHao on 2019/8/6 0006 下午 01:58
 * @author : LiuLiHao
 * 描述：测试cas
 *
 */
public class CASTest {

    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger(10);

        //比较再替换
        System.out.println(atomicInteger.compareAndSet(10, 100));

        System.out.println(atomicInteger.compareAndSet(10, 200)+"  "+ atomicInteger.get());

        //原子引用
        AtomicReference<Student> reference = new AtomicReference<>();

        Student student1 = new Student();
        student1.name = "a";
        Student student2 = new Student();
        student2.name = "b";

        //设置初始值
        reference.set(student1);
        reference.compareAndSet(student1,student2);

        System.out.println(reference.get());
    }
}
