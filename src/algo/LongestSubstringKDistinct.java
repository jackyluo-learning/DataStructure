package algo;

import org.junit.Test;

import java.util.HashMap;

public class LongestSubstringKDistinct {
    public static int findLength(String str, int k) {
        HashMap<Character, Integer> charIndex = new HashMap<>();
        int length = str.length();
        int maxLength = 0;
        int start = 0;
        int end = 0;
        while (end < length) {
            Character current = str.charAt(end);
            charIndex.put(current, end);
            if (charIndex.size() <= k){
                end++;
            }
            else {
                int smallerIndex = length - 1;
                for (Integer each : charIndex.values()) {
                    if (each <= smallerIndex) {
                        smallerIndex = each;
                    }
                }
                charIndex.remove(str.charAt(smallerIndex));
                start = smallerIndex + 1;
            }
//            System.out.println(end - start);
            maxLength = Math.max(maxLength, end - start);
        }
        return maxLength;
    }

    @Test
    public void test() {
        System.out.println(findLength("araaci", 2));
//        System.out.println(findLength("araaci", 1));
//        System.out.println(findLength("cbbebi", 3));
//        System.out.println(findLength("cbbebi", 10));
    }
}