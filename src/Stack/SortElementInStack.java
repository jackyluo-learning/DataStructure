package Stack;

import java.util.Stack;

public class SortElementInStack {
    public static Stack<Integer> sortStack(Stack<Integer> stack){
        Stack<Integer> result = new Stack<>();
        int temp;
        while(!stack.isEmpty()){
            temp = stack.pop();
            while(!result.isEmpty() && result.peek()>=temp){
                stack.push(result.pop());
            }
            result.push(temp);
        }
        return result;
    }
}
