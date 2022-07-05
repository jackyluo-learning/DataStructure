package algo.Sorting;

import java.util.Arrays;

public class SS {
    /*
    Selection Sorting
    最佳情况：T(n) = O(n2)  最差情况：T(n) = O(n2)  平均情况：T(n) = O(n2)
     */

    public static int[] selectionSort(int[] inputArray){
        int[] workArray = Arrays.copyOf(inputArray, inputArray.length);
        int len = inputArray.length;
        for (int i = 0; i < len; i++) {
            int minIndex = i;
            int min = workArray[i];
            for(int j = i; j < len; j++){
                if(workArray[j] < min){
                    min = workArray[j];
                    minIndex = j;
                }
            }
            workArray[minIndex] = workArray[i];
            workArray[i] = min;
        }
        return workArray;
    }
}
