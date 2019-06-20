package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by LiuLiHao on 2019/6/19 0019 下午 08:19
 * @author : LiuLiHao
 * 描述：
 * 逆波兰
 */
public class RePolandCalc {

    public static void main(String[] args) {
        String exp = "4 5 * 8 – 60 + 8 2 / +";
        List<String> list = str2List(exp);
        int calc = calc(list);
        System.out.println(calc);
    }


    /**
     * 转成List
     * @param exp
     * @return
     */
    private static List<String> str2List(String exp){
        String[] split = exp.split(" ");
        ArrayList<String> result = new ArrayList<>();
        for (String s : split) {
            result.add(s);
        }
        return result;
    }

    /**
     * 计算
     * @param list
     * @return
     */
    private static int calc(List<String> list){
        Stack<String> stack = new Stack<>();
        int num1,num2;

        for (String s : list) {
            if (s.matches("\\d+")){
                //是数字 直接入栈
                stack.push(s);
            }else {
                //是符号 取出数字 做计算
                num2 = Integer.parseInt(stack.pop());
                num1 = Integer.parseInt(stack.pop());
                int result = 0;
                switch (s){
                    case "+":
                        result = num1 + num2;
                        break;
                    case "–":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        result = (int) (1.0*num1 / num2);
                        break;
                    default:
                        System.out.println("运算符异常");
                        throw new RuntimeException("运算符异常");
                }
                stack.push(result+"");
            }
        }
        return Integer.parseInt(stack.pop());

    }
}
