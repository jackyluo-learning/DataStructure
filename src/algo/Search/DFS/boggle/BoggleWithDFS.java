/**
 * @author xuqiluo
 * @date 2024-07-31
 */
package algo.Search.DFS.boggle;

import java.util.*;

public class BoggleWithDFS {
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
    private static final int[] ROW = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] COL = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static List<String> findWords(char[][] board, String[] dictionary) {
        Set<String> result = new HashSet<>();
        Set<String> dict = new HashSet<>(Arrays.asList(dictionary));

        int M = board.length;
        int N = board[0].length;
        boolean[][] visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                dfs(board, visited, "", i, j, dict, result);
            }
        }
        return new ArrayList<>(result);
    }

    private static void dfs(char[][] board, boolean[][] visited, String str, int row, int col, Set<String> dict, Set<String> result) {
        visited[row][col] = true;
        str += board[row][col];

        if (dict.contains(str)) {
            result.add(str);
        }

        for (int i = 0; i < 8; i++) {
            int newRow = row + ROW[i];
            int newCol = col + COL[i];
            if (isSafe(newRow, newCol, visited, board.length, board[0].length)) {
                dfs(board, visited, str, newRow, newCol, dict, result);
            }
        }

        visited[row][col] = false;
    }

    private static boolean isSafe(int row, int col, boolean[][] visited, int M, int N) {
        return (row >= 0) && (row < M) && (col >= 0) && (col < N) && (!visited[row][col]);
    }
}
