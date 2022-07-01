package algo.BackTrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    /*
    已选择的路径
     */
    private List<Integer> path;

    /*
    结果集
     */
    private List<List<Integer>> res;

    /*
    标记用过的元素
     */
    private boolean[] used;

    public List<List<Integer>> solution (int[] nums) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        used = new boolean[nums.length];
//        basicBackTrack(nums);
        backTrack(nums);
        return res;
    }

    /**
     * backTrack框架
     * 基础框架，将所有结果都遍历输出
     * @param nums
     * @return
     */
    public void basicBackTrack (int[] nums) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
                path.add(nums[i]);
                basicBackTrack(nums);
                path.remove(path.size() - 1);
        }
    }

    /**
     * 在基础框架上加上判断，如果当前元素已经放进path里，则不加入path
     * @param nums
     */
    public void backTrack (int[] nums) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                basicBackTrack(nums);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }

    @Test
    public void test () {
        int[] nums = {1,2,3};
        System.out.println(solution(nums));
    }

}
