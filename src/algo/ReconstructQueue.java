package algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ReconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    if (o1[1] < o2[1]) {
                        return -1;
                    } else if (o1[1] > o2[1]) {
                        return 1;
                    } else {
                        return 0;
                    }
                } else if (o1[0] > o2[0]) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        List<int[]> resultList = new ArrayList<>();
        for (int[] each : people) {
            resultList.add(each[1], each);
        }
        return resultList.toArray(people);
    }
}
