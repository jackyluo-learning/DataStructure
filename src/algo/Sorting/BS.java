package algo.Sorting;

import java.util.Arrays;

public class BS {
    /*
    Bubble Sorting:
    最佳情况：T(n) = O(n)   最差情况：T(n) = O(n2)   平均情况：T(n) = O(n2)
     */
    public static int[] BS(int[] inputArray){
        int[] workArray = Arrays.copyOf(inputArray, inputArray.length);
        int len = workArray.length;
        for (int i = 0; i < len; i++) {
            for(int j = 0; j<len-1; j++){
                if(workArray[j]>workArray[j+1]){
                    int temp = workArray[j+1];
                    workArray[j+1] = workArray[j];
                    workArray[j] = temp;
                }
            }
        }
        return workArray;
    }
}
