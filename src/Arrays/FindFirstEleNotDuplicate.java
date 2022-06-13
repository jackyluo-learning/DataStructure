package Arrays;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FindFirstEleNotDuplicate {
    public static int findFirstEleNotDuplicate(int[] arr){
        int len = arr.length;
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i<len; i++){
            if(countMap.containsKey(arr[i])){
                countMap.put(arr[i], countMap.get(arr[i])+1);
            }else{
                countMap.put(arr[i], 1);
            }
        }
        Set<Map.Entry<Integer, Integer>> entries = countMap.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries){
            if(entry.getValue()==1){
                return entry.getKey();
            }
        }
        return -1;
    }

    @Test
    public void test(){
        int[] test = new int[]{1,1,1,2,2,2,3,4,4,4,5};
        System.out.println(findFirstEleNotDuplicate(test));
    }
}
