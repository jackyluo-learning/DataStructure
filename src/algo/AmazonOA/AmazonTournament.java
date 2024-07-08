/**
 * @author xuqiluo
 * @date 2024-07-08
 */
package algo.AmazonOA;

import org.junit.Test;

import java.util.Arrays;

public class AmazonTournament {

    /*
        Amazon Care is a healthcare and wellbeing portal for its employees.
        To promote physical fitness, on the portal they launched a "GetFit" tournament consisting of n sprints.
        Each sprint last for a given number of days and includes several tasks such as push-ups, running, etc.
        Some tasks are scheduled for each day of the sprint.
        The i^th sprint lasts for days[i] days, and each sprint starts just after the other.
        That is, if the i^th sprint ends on day d, the (i+1)^th sprint starts on day (d + 1).
        During each sprint, completing the required tasks scheduled on the j^th day of the sprint earns the participant j points.

        The tournaments are periodic, i.e, as soon as the last sprint of a tournament ends, the first sprint of the next tournament begins.
        Each tournament, however, has the same schedule of sprints.
        More formally, the tournament schedule can be considered cyclic in nature and after the last sprint, the first sprint starts again.

        An employee decides to participate. However, due to a tight schedule, the employee cannot complete all tasks every day.
        Instead, the employee will complete the tasks of exactly k consecutive days, hoping to achieve the maximum number of points.

        Given the sprint days of n sprints, and the number of days for which the employee competes for k, find the maximum points the employee can score.
        The training can start and end on any day of any sprint.

        Note:
        1. k is guaranteed to be less than the total number of days for which the sprints last.
        2. Also, it is not necessary to start and end the training in the same tournament.
        3. A sprint here denotes a set of activities performed in a particular time period.

        Function Description
        Complete the function getMaximumPoints in the editor below.
        getMaximumPoints has the following parameters:
        int days[n]: the number of days in each sprint
        int k: the number of consecutive days to train

        Return:
        long_int: the maximum points that can be earned after training for k consecutive days.

        Constrains:
        1 <= n <= 10^5
        1 <= days i <= 10^5, i = 1,2,...,n
        1 <= k <= days[1] + days[2] + ... + days[n]
     */

    public static long getMaximumPoints(int[] days, int k) {
        int totalDays = 0;
        for (int day : days) {
            totalDays += day;
        }

        // 构建积分数组
        int[] points = new int[totalDays];
        int idx = 0;
        for (int day : days) {
            for (int j = 1; j <= day; j++) {
                points[idx++] = j;
            }
        }
        System.out.println("points: " + Arrays.toString(points));

        // 滑动窗口法计算最大积分
        long maxPoints = 0;
        long currentPoints = 0;

        // 初始窗口积分
        for (int i = 0; i < k; i++) {
            currentPoints += points[i % totalDays];
        }
        maxPoints = currentPoints;

        // 滑动窗口，模拟双周期
        for (int i = k; i < totalDays + k; i++) {
            currentPoints += points[i % totalDays] - points[(i - k) % totalDays];
            maxPoints = Math.max(maxPoints, currentPoints);
        }

        return maxPoints;
    }

    @Test
    public void test() {
        int[] days = {3, 2, 4};
        int k = 5;
        System.out.println(getMaximumPoints(days, k));
    }
}
