package thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by LiuLiHao on 2019/7/31 0031 上午 08:48
 * @author : LiuLiHao
 * 描述：测试可见性
 */
public class VolatileTest {
    public static void main(String[] args) {
        Person person = new Person();
        testAtomic(person);
    }

    private static void testAtomic(Person person) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (int j = 0; j < 10000; j++) {
                    //不能保证原子性
                    person.plusPlus();
                    person.atomicAdd();
                }
            }).start();
        }

        //看看操作完成后的结果
        while (Thread.activeCount()>2){
            //如果任务没有执行完成 一直等待
            Thread.yield();
        }
        System.out.println(person.num);
        System.out.println(person.atomicInteger.get());
    }

    /**
     * 测试可见性
     * @param person
     */
    private static void testSee(Person person) {
        new Thread(()->{
            System.out.println("进入线程1");
            try {
                Thread.sleep(2000);
                person.update();
            } catch (InterruptedException e) {

            }

        }).start();

        while (person.num==0){

        }
        System.out.println("结束了");
    }
}
class Person{
    volatile int num = 0;

    /**
     * 默认是0
     */
    AtomicInteger atomicInteger = new AtomicInteger();

    void plusPlus(){
        num++;
    }

    void update(){
        num = 10;
    }

    void atomicAdd(){
        //++操作 是原子性的
        atomicInteger.getAndIncrement();
    }
}
