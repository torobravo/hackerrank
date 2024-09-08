package week4.noprefixset;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'noPrefix' function below.
     *
     * The function accepts STRING_ARRAY words as parameter.
     */

    public static void noPrefix(List<String> words) {
        Trie trie = new Trie();
        for (String word : words) {
            if (!trie.insertNoDuplicates(word)) {
                System.out.println("BAD SET");
                System.out.println(word);
                return;
            }
        }

        System.out.println("GOOD SET");
    }

    static class Trie {
        static class TrieNode {
            TrieNode[] child;
            boolean isEndOfword;

            public TrieNode() {
                child = new TrieNode[26];
                isEndOfword = false;
            }
        }

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public boolean insertNoDuplicates(String word) {
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';

                // check if already contains a complete word
                if (curr.child[index] != null && curr.child[index].isEndOfword)
                    return false;

                // check if current word is a complete word
                if (curr.child[index] != null && i == word.length() - 1)
                    return false;

                if (curr.child[index] == null)
                    curr.child[index] = new TrieNode();

                curr = curr.child[index];
            }
            curr.isEndOfword = true;

            return true;
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> words = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        Result.noPrefix(words);

        bufferedReader.close();
    }
}
