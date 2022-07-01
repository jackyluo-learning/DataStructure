package algo;

public class IndexOfImplementation {
    /*
    Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
    For the purpose of this problem, we will return 0 when needle is an empty string.
    This is consistent to C's strstr() and Java's indexOf().
     */
    public int indexOfImplementation(String haystack, String needle) {
        int lenHay = haystack.length();
        int lenNeedle = needle.length();
        if (lenNeedle == 0) return 0;
        if (lenHay == 0) return -1;

        for (int iH = 0; iH < lenHay; iH++) {
            if (iH + lenNeedle > lenHay) return -1;
            for (int iN = 0; iN < lenNeedle; iN++) {
                if (haystack.charAt(iH + iN) != needle.charAt(iN)) {
                    break;
                }
                if (iN == lenNeedle - 1) {
                    return iH;
                }
            }
        }
        return -1;
    }
}
