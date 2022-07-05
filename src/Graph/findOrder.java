package Graph;

import java.util.*;

public class findOrder {
    /**
     * 现在你总共有 numCourses 门课需要选，记为0到numCourses - 1。给你一个数组prerequisites ，其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
     *
     * 例如，想要学习课程 0 ，你需要先完成课程1 ，我们用一个匹配来表示：[0,1] 。
     * 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。
     */
    public int[] findOrder (int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int[] degree = new int[numCourses];
        Map<Integer, List<Integer>> adjs = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int[] eachPair : prerequisites) {
            // 构建入度表
            degree[eachPair[0]]++;
            // 构建邻接表
            List<Integer> currAdj = adjs.getOrDefault(eachPair[1], new ArrayList<>());
            currAdj.add(eachPair[0]);
            adjs.put(eachPair[1], currAdj);
        }
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0;
        int nums = numCourses;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            res[count] = curr;
            System.out.println(curr + ":" + count);
            count++;
            nums--;
            List<Integer> currAdj = adjs.get(curr);
            if (currAdj != null) {
                for (int each : currAdj) {
                    degree[each]--;
                    if (degree[each] == 0) {
                        queue.offer(each);
                    }
                }
            }
        }
        if (count == numCourses) {
            return res;
        } else {
            return new int[0];
        }
    }
}
