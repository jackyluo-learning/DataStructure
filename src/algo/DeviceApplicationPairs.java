package algo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DeviceApplicationPairs {
    /**
     * Your team at Amazon is working on a system that divides applications to a mixed cluster of computing devices.
     * Each application is identified by an integer ID, requires a fixed non-zero amount of memory to execute, and is defined to be either a foreground or background application.
     * IDs are guaranteed to be unique within their own application type, but not across types.
     * Each device should be assigned two applications at once, one foreground application and one background application.
     * Devices have limited amounts of memory and cannot execute applications that require more memory than the available memory.
     * The goal of the system is to maximize the total utilization of the memory of a given device.
     * A foreground/background application pair is considered to be optimal if there does not exist another pair that uses more memory than this pair, and also has a total less than or equal to the total memory of the device.
     * For example, if the device has 10MB memory, a foreground/background pair using a sum total of 9MB memory would be optimal if there does not exist a pair that uses a sum total of 10 MB, but would not be optimal if such a pair did exist.
     * Write an algorithm to find the sets of foreground and background application pairs that optimally utilize the given device for a given list of foreground applications and a given list of background applications.
     *
     * Examples:
     *
     * Example 1:
     * Input:
     * deviceCapacity = 7
     * foregroundAppList = [[1,2],[2,4],[3,6]]
     * backgroundAppList = [[1,2]]
     * Output:
     * [[2,1]]
     * Explanation:
     * There are only three combinations, [1,1], [2,1], and [3,1], which use a total of 4, 6, and 8 MB memory, respectively. Since 6 is the largest use that does not exceed 7, [2,1] is the only optimal pair.
     *
     * Example2:
     * Input:
     * deviceCapacity = 10
     * foregroundAppList = [[1, 3], [2, 5], [3, 7], [4, 10]]
     * backgroundAppList = [[1, 2], [2, 3], [3, 4], [4, 5]]
     * Output:
     * [[2, 4], [3, 2]]
     * Explanation:
     * There are two pairs of foreground and background applications possible that optimally utilizes the given device.
     * Application 2 from foregroundAppList uses 5 memory units, and application 4 from backgroundAppList also uses 5 memory units. Combined, they add up to 10 units of memory.
     * Similarly, application 3 from foregroundAppList uses 7 memory units, and application 2 from backgroundAppList uses 3 memory units. These also add up to 10 units of memory.
     *
     * Therefore, the pairs of foreground and background applications that optimally utilize the device are [2, 4] and [3, 2].
     * Example3:
     * Input:
     * deviceCapacity = 16
     * foregroundAppList = [[2, 7], [3, 14]]
     * backgroundAppList = [[2, 10], [3, 14]]
     * Output:
     * [()]
     * Explanation:
     * There exist no combination. So, the output is a list with empty pair.
     */

    public List<List<Integer>> solution (int deviceCapacity, List<List<Integer>> foregroundAppList, List<List<Integer>> backgroundAppList){
        foregroundAppList.sort((o1, o2) -> {
            int diff = o1.get(1) - o2.get(1);
            return Integer.compare(diff, 0);
        });

        backgroundAppList.sort((o1, o2) -> {
            int diff = o1.get(1) - o2.get(1);
            return Integer.compare(diff, 0);
        });

        int usedMem = Integer.MIN_VALUE;
        List<List<Integer>> result = new ArrayList<>();
        int forePointer = 0;
        int backPointer = backgroundAppList.size() - 1;
        while (forePointer < foregroundAppList.size() && backPointer >= 0) {
            int totalMem = foregroundAppList.get(forePointer).get(1) + backgroundAppList.get(backPointer).get(1);
            if (totalMem > deviceCapacity) {
                backPointer -= 1;
            } else {
                if (usedMem <= totalMem) {
                    if (usedMem < totalMem) {
                        result.clear();
                        usedMem = totalMem;
                    }
                    List<Integer> current = new ArrayList<>();
                    current.add(foregroundAppList.get(forePointer).get(0));
                    current.add(backgroundAppList.get(backPointer).get(0));
                    result.add(current);
                }
                int bestBack = backPointer;
                while (bestBack > 0 && Objects.equals(backgroundAppList.get(bestBack).get(1), backgroundAppList.get(bestBack - 1).get(1))) {
                    bestBack -= 1;
                }
            }
            forePointer += 1;
        }
        return result;
    }

    @Test
    public void test() {
        int deviceCapacity = 7;
        List<List<Integer>> foregroundAppList = new ArrayList<>();
        List<Integer> foreApp1 = new ArrayList<>();
        foreApp1.add(1);
        foreApp1.add(2);
        List<Integer> foreApp2 = new ArrayList<>();
        foreApp2.add(2);
        foreApp2.add(4);
        List<Integer> foreApp3 = new ArrayList<>();
        foreApp3.add(3);
        foreApp3.add(6);
        foregroundAppList.add(foreApp1);
        foregroundAppList.add(foreApp2);
        foregroundAppList.add(foreApp3);

        List<List<Integer>> backgroundAppList = new ArrayList<>();
        List<Integer> backApp1 = new ArrayList<>();
        backApp1.add(1);
        backApp1.add(2);
//        List<Integer> backApp2 = new ArrayList<>();
//        backApp2.add(3);
//        backApp2.add(14);
        backgroundAppList.add(backApp1);
//        backgroundAppList.add(backApp2);

        System.out.println(solution(deviceCapacity, foregroundAppList, backgroundAppList));
    }
}
