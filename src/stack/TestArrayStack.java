package stack;

/**
 * Created by LiuLiHao on 2019/6/16 0016 下午 08:15
 * @author : LiuLiHao
 * 描述：测试
 */
public class TestArrayStack {

    public static void main(String[] args) {

        ArrayStack stack = new ArrayStack(20);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
