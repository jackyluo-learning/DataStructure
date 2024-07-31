/**
 * @author xuqiluo
 * @date 2024-07-31
 */
package algo.Search.TrieTree;

import org.junit.Test;

public class Trie {

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public TrieNode getRoot() {
        return root;
    }

    // 插入单词
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            int index = currentChar - 'A';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            int index = currentChar - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return node.isEndOfWord;
    }

    public boolean startsWith(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            int index = currentChar - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return true;
    }

    @Test
    public void test() {
        Trie trie = new Trie();
        trie.insert("APPLE");
        System.out.println(trie.search("APP"));
        System.out.println(trie.search("APPE"));
        System.out.println(trie.startsWith("AP"));
        trie.insert("APP");
        System.out.println(trie.search("APP"));
    }
}
