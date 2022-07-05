package algo.Sorting;

import java.util.Arrays;

public class IS {
    /*
    Insertion Sorting
    最佳情况：T(n) = O(n)   最坏情况：T(n) = O(n2)   平均情况：T(n) = O(n2)
     */
    public static int[] insertionSort(int[] inputArray){
        int[] workArray = Arrays.copyOf(inputArray, inputArray.length);
        int len = inputArray.length;
        for (int i = 0; i < len-1; i++) {
            int current = workArray[i+1];
            int j = i;
            while(j>=0 && current < workArray[j]){
                workArray[j+1] = workArray[j];
                j--;
            }
            workArray[j+1] = current;
        }
        return workArray;
    }
}
