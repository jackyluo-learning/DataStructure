/**
 * @author xuqiluo
 * @date 2024-07-31
 */
package algo.Search.DFS.boggle;

import org.junit.Test;

import java.util.List;

public class BoggleTest {

    @Test
    public void test1() {
        char[][] boggle = { { 'G', 'I', 'Z' }, { 'U', 'E', 'K' }, { 'Q', 'S', 'E' } };
        String[] dictionary = { "GEEKS", "FOR", "QUIZ", "GO"};
        List<String> result = BoggleWithDFS.findWords(boggle, dictionary);
        for (String str : result)
            System.out.println("Word: " + str);
    }

    @Test
    public void test2() {
        char[][] boggle = {
                {'D','A','T','H'},
                {'C','G','O','A'},
                {'S','A','T','L'},
                {'B','E','D','G'} };
        String[] dictionary = { "DATA", "HALO", "HALT", "SAG", "BEAT", "TOTAL", "GLOT", "DAG"};
        List<String> result = BoggleWithDFS.findWords(boggle, dictionary);
        for (String str : result)
            System.out.println("Word: " + str);
    }

    @Test
    public void test3() {
        char[][] boggle = {
                {'D','A','T','H'},
                {'C','G','O','A'},
                {'S','A','T','L'},
                {'B','E','D','G'} };
        String[] dictionary = { "DATA", "HALO", "HALT", "SAG", "BEAT", "TOTAL", "GLOT", "DAG"};
        List<String> result = BoggleWithTrie.findWords(boggle, dictionary);
        for (String str : result)
            System.out.println("Word: " + str);
    }
}
