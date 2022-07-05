package algo.Sorting;

import java.util.Arrays;
import java.util.Random;

public class QS {
    /*
    Quick Sorting:

     */
    public static void swap(int[] inputArray, int i, int j){
        /*
        swap two number at position i and j within inputArray
         */
        int temp = inputArray[i];
        inputArray[i] = inputArray[j];
        inputArray[j] = temp;
    }

    public static int partition(int[] inputArray, int start, int end){
        Random random = new Random();
//        System.out.println(String.format("start: %s; end: %s: ", start, end));
        int pivotIndex = random.nextInt(end - start) + start; //random select one pivot from the inputArray
//        System.out.println(String.format("start: %s; end: %s: pivot: %s",start, end, pivotIndex));
//        int pivotIndex = end;
        int pivot = inputArray[pivotIndex];
        int smallPointer = start-1;
        swap(inputArray, pivotIndex, end); //swap the pivot and end element
        for (int i = start; i<end; i++){
            if(inputArray[i] <= pivot){
                smallPointer++;
                swap(inputArray, smallPointer, i);
            }
        }
        swap(inputArray, smallPointer+1, end);
        return smallPointer+1;
    }

    public static void qs(int[] inputArray, int start, int end){
        if(end <= start || inputArray == null) return;
        else {
//            System.out.println(start+" "+end);
            int pivot = partition(inputArray, start, end);
            qs(inputArray, start, pivot-1);
            qs(inputArray, pivot + 1, end);
        }
    }

    public static int[] quickSort(int[] inputArray) {
        int[] workingArray = Arrays.copyOf(inputArray, inputArray.length);
        qs(workingArray, 0, workingArray.length - 1);
        return workingArray;
    }
}