package Queues;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack2 {

    private Queue<Integer> queue = new LinkedList<>();
    private int top;

    public MyStack2(){

    }

    public void push(int val){
        top = val;
        queue.add(val);
    }

    public int pop(){
        int tmp = 0;
        int tmpTop = top;
        while(!queue.isEmpty()){
            tmp = queue.remove();
            if(tmp == top){
                top = tmpTop;
                return tmp;
            }
            queue.add(tmp);
            tmpTop = tmp;
        }
        return -1;
    }

    public int top(){
        return top;
    }
}
