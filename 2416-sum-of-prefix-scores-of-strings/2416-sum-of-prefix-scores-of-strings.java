import java.util.*;

class Trie {
    Trie[] child;
    int score;

    public Trie() {
        child = new Trie[26];
        score = 0;
    }
}

class Solution {
    public int[] sumPrefixScores(String[] words) {
        Trie root = new Trie();
        int[] result = new int[words.length];

        for (String word : words) {
            Trie current = root;
            for (char c : word.toCharArray()) {
                if (current.child[c - 'a'] == null) {
                    current.child[c - 'a'] = new Trie();
                }
                current = current.child[c - 'a'];
                current.score++;
            }
        }

        for (int i = 0; i < words.length; i++) {
            Trie current = root;
            int score = 0;
            for (char c : words[i].toCharArray()) {
                current = current.child[c - 'a'];
                score += current.score;
            }
            result[i] = score;
        }

        return result;
    }
}
