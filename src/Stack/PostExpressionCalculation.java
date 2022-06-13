package Stack;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class PostExpressionCalculation {
    public int cal(String exp){
        int len = exp.length();
        Stack<Integer> storage = new Stack();
        int result;
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(exp.charAt(i))){
                storage.push(Character.getNumericValue(exp.charAt(i)));
            }
            else{
                char op = exp.charAt(i);
                int val1 = storage.pop();
                int val2 = storage.pop();
                switch (op) {
                    case '*':
                        result = val2 * val1;
                        break;
                    case '+':
                        result = val2 + val1;
                        break;
                    case '-':
                        result = val2 - val1;
                        break;
                    case '/':
                        result = val2 / val1;
                        break;
                    default: throw new IllegalStateException("Unexpected value: " + op);
                }
                storage.push(result);
            }
        }
        return storage.pop();
    }

    @Test
    public void test(){
        String exp = "231*+9-";
        Assert.assertEquals(-4, cal(exp));
    }
}
