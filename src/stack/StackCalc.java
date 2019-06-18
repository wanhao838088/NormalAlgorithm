package stack;

/**
 * Created by LiuLiHao on 2019/6/17 0017 下午 05:25
 * @author : LiuLiHao
 * 描述：用栈实现计算器
 */
public class StackCalc {

    public static void main(String[] args) {
        ArrayStack numStack = new ArrayStack(20);
        ArrayStack operatorStack = new ArrayStack(20);

        String exp = "1+1*5-2+5";
        //遍历的下标
        int index = 0;
        int num1,num2,result;
        char ch;
        while (index<exp.length()){
            //取出字符
            ch = exp.charAt(index);
            //是否是操作符
            if (operatorStack.isOperator(ch)){
                if (operatorStack.isEmpty()){
                    //第一个符号
                    operatorStack.push(ch);
                }else {
                    //判断优先级
                    if (operatorStack.prior(ch)<=operatorStack.prior(operatorStack.peekLast())){
                        //进行计算
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        int pop = operatorStack.pop();
                        result = operatorStack.calc(num1,num2,pop);
                        numStack.push(result);
                        //符号入栈
                        operatorStack.push(ch);
                    }else {
                        operatorStack.push(ch);
                    }
                }
            }else {
                numStack.push(ch-48);
            }
            index++;

        }

        while (!operatorStack.isEmpty()){
            //计算最后一个数
            num1 = numStack.pop();
            num2 = numStack.pop();
            result = operatorStack.calc(num1,num2,operatorStack.pop());
            numStack.push(result);
        }
        System.out.println(numStack.pop());
    }
}
