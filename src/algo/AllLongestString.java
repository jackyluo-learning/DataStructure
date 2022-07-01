package algo;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllLongestString {
    String[] result;

    @Before
    public void before() {
        result = new String[]{"abcda", "eh", "jiufa", "jfda", "fja"};
    }

    @Test
    public void test_method1() {
        Assert.assertEquals(Arrays.toString(new String[]{"abcda", "jiufa"}), Arrays.toString(allLongestString1(result)));
    }

    @Test
    public void test_method2() {
        Assert.assertEquals(Arrays.toString(new String[]{"abcda", "jiufa"}), Arrays.toString(allLongestString2(result)));
    }

    @After
    public void after() {
        result = null;
    }

    public String[] allLongestString1(String[] strs) {
        int len = strs.length;
        List<String> resultList = new ArrayList<>();
        int temp = 0;
        for (int i = 0; i < len; i++) {
            if (strs[i].length() > temp) {
                temp = strs[i].length();
                resultList.clear();
                resultList.add(strs[i]);
            } else if (strs[i].length() == temp) {
                resultList.add(strs[i]);
            }
        }
        String[] strings = (String[]) resultList.toArray(new String[resultList.size()]);
        return strings;
    }

    public String[] allLongestString2(String[] inputArray) {
        List<String> list = new ArrayList<>();
        int maxLen = 0;
        for (String s : inputArray) {
            int len = s.length();
            if (len >= maxLen) {
                maxLen = len;
            }
        }

        for (String s : inputArray) {
            if (s.length() == maxLen) {
                list.add(s);
            }
        }
        String[] resultStrings = new String[list.size()];
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                resultStrings[i] = String.valueOf(list.get(i));
            }
        }

        return resultStrings;
    }
}
