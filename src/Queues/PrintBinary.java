package Queues;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintBinary {
    public static List<List<String>> printBinary(int n){
        Queue<String> waitQueue = new LinkedList<>();
        ArrayList<List<String>> result = new ArrayList<>();
        waitQueue.add("1");
        while (!waitQueue.isEmpty() && n>0){
            List<String> level = new ArrayList<>();
            int level_len = waitQueue.size();
            for(int i = 0; i<level_len; i++) {
                String origin = waitQueue.poll();
                StringBuilder sb0 = new StringBuilder(origin);
                StringBuilder sb1 = new StringBuilder(origin);
                if (n>0) {
                    level.add(origin);
                    n--;
                }
                sb0.append(0);
                waitQueue.add(sb0.toString());
                sb1.append(1);
                waitQueue.add(sb1.toString());
            }
            result.add(level);
        }
        return result;
    }

    @Test
    public void test(){
        System.out.println(printBinary(6));
    }
}
