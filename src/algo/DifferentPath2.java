package algo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DifferentPath2 {
    public int solution (int[][] map) {
        int[][] dp = new int[map.length][map[0].length];
        dp[0][0] = map[0][0];
        List<int[]> path = new ArrayList<>();
        for (int i = 1; i < map.length; i++) {
            dp[i][0] = dp[i-1][0] + map[i][0];
        }
        for (int j = 1; j < map[0].length; j++) {
            dp[0][j] += dp[0][j-1] + map[0][j];
        }

        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map[0].length; j++) {
                int minPath = Math.min(dp[i-1][j], dp[i][j-1]);
                dp[i][j] = minPath + map[i][j];
            }
        }
        return dp[map.length-1][map[0].length-1];
    }

    @Test
    public void test () {
        int[][] map = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        System.out.println(solution(map));
    }
}
