package Stack;

import org.junit.Test;

import java.util.Stack;

public class TestCase {
    @Test
    public void testMyQueue(){
        MyQueue q = new MyQueue();
        q.Enqueue(1);
        q.Enqueue(2);
        q.Enqueue(3);
        q.Enqueue(4);
        System.out.println(q.Dequeue());
    }

    @Test
    public void testSort(){
        Stack<Integer> stack = new Stack<>();
        stack.push(34);
        stack.push(3);
        stack.push(31);
        stack.push(92);
        stack.push(23);
        Stack result = SortElementInStack.sortStack(stack);
        printStackFromButtom(result);
    }

    public void printStackFromButtom(Stack stack){
        if(stack.isEmpty()) return;
        Object temp = stack.pop();
        printStackFromButtom(stack);
        System.out.println(temp + " ");
    }
}
