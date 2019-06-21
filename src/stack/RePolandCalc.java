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
//        String exp = "4 -5 * 8 – 60 + 8 2 / +";
//        List<String> list = str2List(exp);
//        int calc = calc(list);
//        System.out.println(calc);

        //把中缀表达式转成后缀表达式
        String exp = "1+((2+3)*4)-5";
        List<String> list = exp2List(exp);
        System.out.println("中缀的list  "+list);
        List<String> suffix = mid2Suffix(list);
        System.out.println("后缀的list  "+suffix);
        int calc = calc(suffix);
        System.out.println("计算的结果  "+calc);
    }

    /**
     * 中缀表达式转后缀
     * @param list
     * @return
     */
    private static List<String> mid2Suffix(List<String> list){
        //由于结果只入 不出 所以使用list
        List<String> s2 = new ArrayList<>();
        Stack<String> s1 = new Stack<>();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            //判断是否是数字
            if(s.matches("\\d+")){
                //是数字 直接放入list
                s2.add(s);
            }else {
                //如果为空 或栈顶运算符为左括号“(”，则直接将此运算符入栈；
                if (s.equals("(")){
                    s1.push(s);
                }else if(s.equals(")")) {
                    //则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
                    while (!s1.peek().equals("(")){
                        s2.add(s1.pop());
                    }
                    s1.pop();
                } else {
                    while (s1.size()!=0 && operatorPrior(s)<= operatorPrior(s1.peek())){
                        s2.add(s1.pop());
                    }
                    s1.push(s);
                }
            }
        }
        //将s1中剩余的运算符依次弹出并压入s2
        while (s1.size()!=0){
            s2.add(s1.pop());
        }

        return s2;
    }

    /**
     * 把表达式转换成List
     * @param exp
     * @return
     */
    private static List<String> exp2List(String exp){
        ArrayList<String> list = new ArrayList<>();
        int index=0;
        String temp = "";

        while (index<exp.length()){
            char c = exp.charAt(index);
            if (c>47 && c<58){
                temp = "";
                //是数字 继续往后
                while (true){
                    if (index<exp.length()){
                        c = exp.charAt(index);
                    }else {
                        break;
                    }
                    if (c>47 && c<58){
                        temp+=c;
                    }else {
                        index--;
                        break;
                    }
                    index++;
                }
                list.add(temp);
            }else {
                //直接入
                list.add(c+"");
            }
            index++;
        }
        return list;
    }


    /**
     * 判断运算符优先级
     * @param s
     * @return
     */
    private static int operatorPrior(String s){
        switch (s){
            case "+":
                return 1;
            case "-":
                return 1;
            case "*":
                return 2;
            case "/":
                return 2;
                default:
                    System.out.println("未知运算符");
                    return 0;
        }
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
                    case "-":
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
                        //throw new RuntimeException("运算符异常");
                }
                stack.push(result+"");
            }
        }
        return Integer.parseInt(stack.pop());

    }
}
