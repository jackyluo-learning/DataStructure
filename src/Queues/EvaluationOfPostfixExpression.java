package Queues;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class EvaluationOfPostfixExpression {
    /*
    Example:
    Let the given expression be “2 3 1 * + 9 -“. We scan all elements one by one.
    1) Scan ‘2’, it’s a number, so push it to stack. Stack contains ‘2’
    2) Scan ‘3’, again a number, push it to stack, stack now contains ‘2 3’ (from bottom to top)
    3) Scan ‘1’, again a number, push it to stack, stack now contains ‘2 3 1’
    4) Scan ‘*’, it’s an operator, pop two operands from stack, apply the * operator on operands, we get 3*1 which results in 3. We push the result ‘3’ to stack. Stack now becomes ‘2 3’.
    5) Scan ‘+’, it’s an operator, pop two operands from stack, apply the + operator on operands, we get 3 + 2 which results in 5. We push the result ‘5’ to stack. Stack now becomes ‘5’.
    6) Scan ‘9’, it’s a number, we push it to the stack. Stack now becomes ‘5 9’.
    7) Scan ‘-‘, it’s an operator, pop two operands from stack, apply the – operator on operands, we get 5 – 9 which results in -4. We push the result ‘-4’ to stack. Stack now becomes ‘-4’.
    8) There are no more elements to scan, we return the top element from stack (which is the only element left in stack).
     */
    public int evluatePostfix(String exp) {
        int len = exp.length();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            char c = exp.charAt(i);
            if (Character.isDigit(c)) {
                stack.push(Character.getNumericValue(c));
            } else {
                int val1 = stack.pop();
                int val2 = stack.pop();
                switch (c) {
                    case '*':
                        stack.push(val2 * val1);
                        break;
                    case '+':
                        stack.push(val2+val1);
                        break;
                    case '-':
                        stack.push(val2-val1);
                        break;
                    case '/':
                        stack.push(val2/val1);
                        break;
                }
            }
        }
        return stack.pop();
    }

    @Test
    public void test(){
        Assert.assertEquals(-4, evluatePostfix("231*+9-"));
    }
}
