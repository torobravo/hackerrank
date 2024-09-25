package dsa.trie;

public class Solution {
    static class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        public TrieNode() {
            // 26 English letters
            children = new TrieNode[26];
            isEndOfWord = false;
        }
    }

    static class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Insert a word into the Trie
        public void insert(String word) {
            TrieNode current = root;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (current.children[index] == null) {
                    current.children[index] = new TrieNode();
                }
                current = current.children[index];
            }
            current.isEndOfWord = true;
        }

        // Search a word in the Trie
        public boolean search(String word) {
            TrieNode current = root;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (current.children[index] == null)
                    return false;
                current = current.children[index];
            }

            return current != null && current.isEndOfWord;
        }

        // Check if a given prefix exits in the Trie
        public boolean startWith(String prefix) {
            TrieNode current = root;
            for (char ch : prefix.toCharArray()) {
                int index = ch - 'a';
                if (current.children[index] == null)
                    return false;
                current = current.children[index];
            }
            return true;
        }

    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        // insert
        trie.insert("box");
        trie.insert("bat");
        trie.insert("ball");
        trie.insert("cat");
        trie.insert("chai");
        // search
        System.out.println(trie.search("ball"));
        System.out.println(trie.search("casa"));
        // startWith (prefix)
        System.out.println(trie.startWith("cha"));
        System.out.println(trie.startWith("done"));
    }
}
