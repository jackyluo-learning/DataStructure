package Stack;

import org.junit.Test;

import java.util.HashMap;
import java.util.Stack;

public class MiddleExpToPostExp {
    public String transfer(String middleExp) {
        Stack<Character> storage = new Stack<>();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < middleExp.length(); i++) {
            char component = middleExp.charAt(i);
            if (Character.isDigit(component)) {
                result.append(component);
            } else if (component == '(') {
                storage.push(component);
            } else if (component == ')') {
                while (!storage.isEmpty() && storage.peek() != '(') {
                    result.append(storage.pop());
                }
                storage.pop();
            } else if (component == '+' || component == '-' || component == '*' || component == '/') {
                while (!storage.isEmpty() && operationCompare(component, storage.peek())) {
                    result.append(storage.pop());
                }
                storage.push(component);
            } else return "Null";
        }
        while (!storage.isEmpty()){
            result.append(storage.pop());
        }
        return result.toString();
    }

    public boolean operationCompare(char left, char right) {
        if (Character.isDigit(left) || Character.isDigit(right)) return false;
        HashMap<Character, Integer> operationLevel = new HashMap<>();
        operationLevel.put('(', 0);
        operationLevel.put('+', 1);
        operationLevel.put('-', 1);
        operationLevel.put('*', 2);
        operationLevel.put('/', 2);
        try {
            return operationLevel.get(left) <= operationLevel.get(right);
        }catch (NullPointerException e){
            System.out.println("This operation can not be found.");
            return false;
        }
    }

    @Test
    public void test() {
        String test = "3+(6-4/2)*5";
        System.out.println(transfer(test));
    }
}
