package algo.BackTrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    // 结果集
    private List<List<String>> res;

    // 当前路径
    private List<String> path;

    // 存放可选择元素
    private Set<String> wordSet;

    public boolean wordBreak1 (String s, List<String> wordDict){
        wordSet = new HashSet<>();
        wordSet.addAll(wordDict);
        return breakTrack1(s, 0);
    }


    /**
     * 返回可以组成s的wordDict中的单词组合
     * @param s
     * @param wordDict
     * @return
     */
    public List<List<String>> wordBreak2 (String s, List<String> wordDict){
        wordSet = new HashSet<>();
        res = new ArrayList<>();
        path = new ArrayList<>();
        wordSet.addAll(wordDict);
        backTrack(s, 0);
        return res;
    }

    public void backTrack (String s, int start) {
        if (start >= s.length()) {
            res.add(new ArrayList<>(path));
        }
        for (int i = start; i < s.length(); i++) {
            String currentWord = s.substring(start, i + 1);
            if (!wordSet.contains(currentWord)) {
                continue;
            }
            path.add(currentWord);
            backTrack(s, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public boolean breakTrack1 (String s, int start) {
        if (start == s.length()) {
            return true;
        }
        for (int i = start; i < s.length(); i++) {
            String currentString = s.substring(start, i+1);
            if (!wordSet.contains(currentString)) {
                continue;
            }
            boolean res =  breakTrack1(s, i + 1);
            if (res) return res;
        }
        return false;
    }

    @Test
    public void test () {
        String s = "catsandog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");
        System.out.println(wordBreak2(s, wordDict));
        String s1 = "catsandog";
        List<String> wordDict1 = new ArrayList<>();
        wordDict1.add("cats");
        wordDict1.add("dog");
        wordDict1.add("sand");
        wordDict1.add("and");
        wordDict1.add("cat");
        System.out.println(wordBreak1(s1, wordDict1));
    }
}
