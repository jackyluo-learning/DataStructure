package Arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class RearrangePosNeg {
    /*
    An array contains both positive and negative numbers in random order.
    Rearrange the array elements so that positive and negative numbers are placed alternatively.
    Number of positive and negative numbers need not be equal.
    If there are more positive numbers they appear at the end of the array.
    If there are more negative numbers, they too appear in the end of the array.
    For example, if the input array is [-1, 2, -3, 4, 5, 6, -7, 8, 9],
    then the output should be [9, -7, 8, -3, 5, -1, 2, 4, 6]
     */
    public int[] rearrangePosNeg(int[] arr) {
        int i = rearrange2(arr);
        int len = arr.length;
        int pos = i;
        int neg = 0;
        while (pos < len && arr[neg] < 0 && neg < pos) {
            int temp = arr[neg];
            arr[neg] = arr[pos];
            arr[pos] = temp;
            pos++;
            neg += 2;
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    public int rearrange1(int[] input){
        int length = input.length;
        int j = -1;
        for (int k = 0; k < length; k++) {
            if (input[k] < 0){
                j++;
                int temp = input[k];
                input[k] = input[j];
                input[j] = temp;
            }
        }
        return j+1;
    }

    public int rearrange2(int[] input){
        int len = input.length;
        int i = 0;
        int j = len - 1;
        int temp = 0;
        while (j > i) {
            while (input[i] < 0) {
                i++;
            }
            while (input[j] > 0) {
                j--;
            }
            if (j > i) {
                temp = input[j];
                input[j] = input[i];
                input[i] = temp;
            }
        }
        return i;
    }

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[]{3, -4, 2, -1, 1, 4}, rearrangePosNeg(new int[]{1, 2, 3, -4, -1, 4}));
        int[] arr = new int[]{-4, 1, 2, 0, 8, -7, -6, -1, 7};
        rearrange1(arr);
        Assert.assertArrayEquals(new int[]{-4, -7, -6, -1, 8, 1, 2, 0, 7}, arr);
    }

}
