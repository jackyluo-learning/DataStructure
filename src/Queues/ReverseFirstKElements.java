package Queues;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseFirstKElements {

    public Queue reverseQueueFirstKElement(Queue<Integer> input, int k){
//        Queue<Integer> queue = new LinkedList.LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        int len = input.size();
        for (int i = 0; i<k; i++){
            stack.push(input.remove());
        }
        while (!stack.isEmpty()){
            input.add(stack.pop());
        }
        for (int i = 0; i<len-k; i++){
            input.add(input.remove());
        }
        return input;
    }

    @Test
    public void test(){
        Queue queue = new LinkedList<Integer>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        queue.add(60);
        queue.add(70);
        queue.add(80);
        queue.add(90);
        queue.add(100);

        int k = 5;
        System.out.println(reverseQueueFirstKElement(queue, k));
    }
}
