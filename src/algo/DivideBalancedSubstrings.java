package algo;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class DivideBalancedSubstrings {
    /*
      A string that contains only the following => ‘(‘, ‘)’, ‘[’, ‘]’. At some places there is ‘?’ in place of any bracket.
      Determine the number of WAYS OF DIVIDING THE STRING INTO TWO SUBSTRINGS to form two balanced substrings.
      Each substring can be formed by replacing all ‘?’s with appropriate bracket to make it a balanced substring.
     */

    public Integer solution (String inputString) {
        Map<Integer, Integer> leftToRight = new HashMap<>();
        Map<Integer, Integer> rightToLeft = new HashMap<>();
        Map<Integer, Integer> numsOfQuestionMark = new HashMap<>();

        int result = 0;
        int len = inputString.length();
        if (len == 0) return result;
        if (len % 2 != 0) return result;

        int sqCount = 0;
        int cirCount = 0;
        int revSqCount = 0;
        int revCirCount = 0;
        int questionMarkCount = 0;
        for (int i = 0; i < len; i++) {
            int j = len - i - 1;
            char leftToRightChar = inputString.charAt(i);
            char rightToLeftChar = inputString.charAt(j);
            sqCount += leftToRightChar == '[' ? 1 : leftToRightChar == ']' ? -1 : 0;
            cirCount += leftToRightChar == '(' ? 1 : leftToRightChar == ')' ? -1 : 0;
            revSqCount += rightToLeftChar == '[' ? 1 : rightToLeftChar == ']' ? -1 : 0;
            revCirCount += rightToLeftChar == '(' ? 1 : rightToLeftChar == ')' ? -1 : 0;
            questionMarkCount = leftToRightChar == '?' ? i == 0 ? 1 : numsOfQuestionMark.get(i-1) + 1 : i == 0 ? 0 : numsOfQuestionMark.get(i-1);

            // to count the nums of addition number of sqCount and cirCount that needed to be replaced by question mark,
            // the number of sqCount and cirCount should be absolute, because either '[' or ']' are regarded as bracket that needed a closing bracket
            leftToRight.put(i, Math.abs(sqCount) + Math.abs(cirCount));
            rightToLeft.put(j, Math.abs(revSqCount) + Math.abs(revCirCount));
            numsOfQuestionMark.put(i, questionMarkCount);
        }
        System.out.println(leftToRight);
        System.out.println(rightToLeft);
        System.out.println(numsOfQuestionMark);

        for (int i = 1; i < len - 1; i++) {
            int leftDiff = numsOfQuestionMark.get(i) - leftToRight.get(i);
            // To ensure the rest of the question mark can be replaced into bracket,
            // the number of the rest of question mark should be divided by 2 completely,
            // otherwise there will be question marks left that can not be replaced by closing brackets.
            if (leftDiff >= 0 && leftDiff % 2 == 0) {
                int rightDiff = (numsOfQuestionMark.get(len - 1) - numsOfQuestionMark.get(i)) - rightToLeft.get(i+1);
                if (rightDiff >= 0 && rightDiff % 2 == 0) {
                    result++;
                }
            }
        }
        return result;
    }

    @Test
    public void test () {
        String test1 = "[]?]";
        System.out.println(solution(test1));

        String test2 = "(](]";
        System.out.println(solution(test2));

        String test3 = "[(?][??[";
        System.out.println(solution(test3));
    }
}
