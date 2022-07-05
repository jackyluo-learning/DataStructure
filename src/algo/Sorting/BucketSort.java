package algo.Sorting;

import java.util.ArrayList;

public class BucketSort {
    public static int[] bucketSort (int[] inputArray, int bucketNum) {
        int len = inputArray.length;
        int[] result = new int[len];
        int maxVal = inputArray[0];
        int minVal = inputArray[0];
        for (int value : inputArray) {
            if (value >= maxVal) {
                maxVal = value;
            }
            if (value <= minVal) {
                minVal = value;
            }
        }
        int diff = maxVal - minVal;
        // 将元素分桶时使用
        double space = (double) (diff + 1) / bucketNum;
        ArrayList<Integer>[] sortList = new ArrayList[bucketNum];
        for (int j : inputArray) {
            int bucketIndex = (int) Math.floor((j - minVal) / space);
            ArrayList<Integer> bucket = sortList[bucketIndex];
            if (bucket == null) {
                bucket = new ArrayList<>();
                bucket.add(j);
                sortList[bucketIndex] = bucket;
            } else {
                int bucketSize = bucket.size();
                int k = bucketSize - 1;
                while (k >= 0 && bucket.get(k) > j) {
                    Integer currK = bucket.get(k);
                    if (k == bucketSize - 1) {
                        // 若k是当前桶的最后一个，需要将其放到最后，以便将inputArray[i]放进k的位置
                        bucket.add(currK);
                    } else {
                        // 若k不是当前桶的最后一个，需要将其往后放一格，以便将inputArray[i]放进k的位置
                        bucket.set(k + 1, currK);
                    }
                    k--;
                }
                if (k == bucketSize - 1) {
                    //若k没有变化，说明当前bucket中没有比inputArray[i]大的或者当前bucket是空的，则直接加入inputArray[i]
                    bucket.add(j);
                } else {
                    // 将inputArray[i]放进k+1的位置，因为上面k--了。
                    bucket.set(k + 1, j);
                }
            }

        }
        int count = 0;
        for (ArrayList<Integer> each : sortList) {
            if (each != null && each.size() > 0) {
                for (Integer integer : each) {
                    result[count] = integer;
                    count++;
                }
            }
        }
        return result;
    }
}
