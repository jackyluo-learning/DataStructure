package Queues;

import org.junit.Test;

public class TestCases {
    @Test
    public void testMyStack(){
        System.out.println("MyStack: ");
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.top());
        stack.push(4);
        System.out.println(stack.top());
    }

    @Test
    public void testMyStack2(){
        System.out.println("MyStack2: ");
        MyStack2 stack = new MyStack2();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.top());
        stack.push(4);
        System.out.println(stack.top());
    }
}
