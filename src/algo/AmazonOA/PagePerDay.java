/**
 * @author xuqiluo
 * @date 2024-07-08
 */
package algo.AmazonOA;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class PagePerDay {

    /*
    学生需要在规定的 days 天数内，完成阅读 n 个章节，每个章节的页数由数组 pages 提供，其中 pages[i] 表示第 i 个章节的页数。
    学生每天可以阅读至多 x 页或者读完一个章节，以较小者为准。在阅读过程中，学生按照章节的顺序阅读，每天只能阅读一个章节的内容。
    如果在一天内读不完一个章节，第二天继续读这个章节的剩余部分。

        例如，假设 pages = [5, 3, 4] 和 x = 4：

        第一天：学生读4页第一个章节，剩余 pages = [1, 3, 4]。
        第二天：学生读完第一个章节，剩余 pages = [0, 3, 4]。
        第三天：学生读完第二个章节（因为3页小于4页），剩余 pages = [0, 0, 4]。
        第四天：学生读完第三个章节，剩余 pages = [0, 0, 0]。
        给定 n 个章节的页数 pages 和规定的天数 days，要求找到每天至少要读多少页 x 才能在规定的 days 天内读完所有章节。如果无法在规定的 days 天内读完，返回 -1。
     */

    public static int minimumNumberOfPages(List<Integer> pages, int days) {
        int start = 1;
        int end = 0;
        int result = -1;
        if (pages.isEmpty()) return result;
        for (int eachPage : pages) {
            end = Math.max(end, eachPage);
        }
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if (canFinish(pages, days, mid)) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }

    // 辅助函数，判断如果每天读x页，是否能在days天内完成所有章节
    private static boolean canFinish(List<Integer> pages, int days, int x) {
        int totalDays = 0; // 累计总天数
        for (int pagesInChapter : pages) {
            totalDays += (pagesInChapter + x - 1) / x; // 计算完成当前章节需要的天数并累加
            if (totalDays > days) {
                return false; // 如果累加的天数超过规定的天数，返回false
            }
        }
        return true; // 如果所有章节在规定天数内读完，返回true
    }

    @Test
    public void test() {
        List<Integer> pages = List.of(2,3,4,5);
        int days = 5;
        Assert.assertEquals(minimumNumberOfPages(pages, days), 4); // 4
    }
}
