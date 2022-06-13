package Stack;

import java.util.Stack;

public class MyQueue<T> {
    private Stack<T> stack1 = new Stack<>();
    private Stack<T> stack2 = new Stack<>();

    public MyQueue(){
    }

    public void Enqueue(T value){
        stack1.push(value);
    }

    public T Dequeue(){
        if(!stack2.isEmpty()){
            return stack2.pop();
        }else if(!stack1.isEmpty()){
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
