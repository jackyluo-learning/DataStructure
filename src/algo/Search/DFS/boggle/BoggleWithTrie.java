/**
 * @author xuqiluo
 * @date 2024-07-31
 */
package algo.Search.DFS.boggle;

import algo.Search.TrieTree.Trie;
import algo.Search.TrieTree.TrieNode;

import java.util.ArrayList;
import java.util.List;

public class BoggleWithTrie {

    /*
    Given a dictionary, a method to do lookup in dictionary and a M x N board where every cell has one character.
    Find all possible words that can be formed by a sequence of adjacent characters.
    Note that we can move to any of 8 adjacent characters, but a word should not have multiple instances of same cell.
        Input: dictionary[] = {"GEEKS", "FOR", "QUIZ", "GO"};
        boggle[][]   = {{'G', 'I', 'Z'},
                       {'U', 'E', 'K'},
                       {'Q', 'S', 'E'}};
        isWord(str): returns true if str is present in dictionary
                   else false.

        Output:  Following words of dictionary are present
         GEEKS
         QUIZ
     */
    private static int[] ROW = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static int[] COL = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static List<String> findWords(char[][] board, String[] dictionary) {
        List<String> result = new ArrayList<>();
        Trie trie = new Trie();
        for (String word : dictionary) {
            trie.insert(word);
        }

        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                searchWords(board, visited, i, j, "", trie.getRoot(), result);
            }
        }
        return result;
    }

    public static void searchWords(char[][] board, boolean[][] visited,
                                   int row, int col, String str,
                                   TrieNode node, List<String> result) {
        if (!isValid(row, col, board, visited)) {
            return;
        }

        char ch = board[row][col];
        int index = ch - 'A';
        node = node.getChildren()[index];
        if (node == null) {
            return;
        }

        str += ch;
        if (node.isEndOfWord()) {
            result.add(str);
        }

        visited[row][col] = true;
        for (int i = 0; i < 8; i++) {
            searchWords(board, visited, row+ROW[i], col+COL[i], str, node, result);
        }
        visited[row][col] = false;
    }

    private static boolean isValid(int row, int col, char[][] board, boolean[][] visited) {
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length && !visited[row][col];
    }
}
