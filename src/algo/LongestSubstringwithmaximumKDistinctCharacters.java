package algo;

import java.util.HashMap;

public class LongestSubstringwithmaximumKDistinctCharacters {
    public static int findLength(String str, int k) {
        HashMap<Character, Integer> charCount = new HashMap<>();
        int length = str.length();
        int maxLength = 0;
        int start = 0;
        for (int end = 0; end < length; end++) {
            Character current = str.charAt(end);
            if (charCount.keySet().size() > k) {
                Character startChar = str.charAt(start);
                int left = charCount.get(startChar) - 1;
                if (left == 0) {
                    charCount.remove(startChar);
                } else {
                    charCount.put(startChar, left);
                }
                start++;
            } else {
                if (charCount.containsKey(current)) {
                    charCount.put(current, charCount.get(current) + 1);
                } else {
                    charCount.put(current, 1);
                }
                if (end - start + 1 > maxLength) {
                    maxLength = end-start+1;
                }
            }
        }
        return maxLength;
    }
}
