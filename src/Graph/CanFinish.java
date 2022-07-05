package Graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class CanFinish {
    /**
     * 你这个学期必须选修 numCourses 门课程，记为0到numCourses - 1 。
     *
     * 在选修某些课程之前需要一些先修课程。 先修课程按数组prerequisites 给出，其中prerequisites[i] = [ai, bi] ，表示如果要学习课程ai 则 必须 先学习课程  bi 。
     *
     * 例如，先修课程对[0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
     * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
     */

    private Map<Integer, List<Integer>> adjListArray;

    private int[] visit;

    public boolean canFinishDFS (int numCourses, int[][] prerequisites) {
        // 构建访问表
        visit = new int[numCourses];
        // 构建邻接表
        for (int[] eachPair : prerequisites) {
            // 构建邻接表
            List<Integer> currAdj = this.adjListArray.getOrDefault(eachPair[1], new ArrayList<>());
            currAdj.add(eachPair[0]);
            this.adjListArray.put(eachPair[1], currAdj);
        }
        for (Map.Entry<Integer, List<Integer>> each : this.adjListArray.entrySet()) {
            if (!dfs(each.getKey())) return false;
        }
        return true;
    }

    public boolean dfs (int currentNode) {
        if (this.visit[currentNode] == -1) return true;
        if (this.visit[currentNode] == 1) return false;
        List<Integer> currAdj = this.adjListArray.get(currentNode);
        if (currAdj != null) {
            this.visit[currentNode] = 1;
            for (int eachNode : currAdj) {
                if (!dfs(eachNode)) return false;
            }
            this.visit[currentNode] = -1;
        }
        return false;
    }

    public boolean canFinish (int numCourses, int[][] prerequisites) {
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
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            numCourses--;
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
        return numCourses == 0;
    }

    @Test
    public void test() {
        int testNum = 4;
        int[][] prerequisites = {
                {1,0},
                {2,0},
                {3,1},
                {3,2}
        };
        Assert.assertTrue(canFinish(testNum, prerequisites));
    }
}
