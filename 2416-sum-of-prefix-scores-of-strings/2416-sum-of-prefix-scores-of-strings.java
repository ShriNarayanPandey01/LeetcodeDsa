import java.util.*;

class Trie {
    Trie[] child;
    int[] alp;
    char letter;

    public Trie() {
        child = new Trie[26];
        alp = new int[26];
    }
}

class Solution {
    public int[] sumPrefixScores(String[] words) {
        Trie root = new Trie();
        for (String word : words) {
            insertWord(root, word);
        }
        int[] result = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            result[i] = countScore(root, words[i], 0);
        }
        return result;
    }

    public void insertWord(Trie root, String word) {
        Trie current = root;
        for (char c : word.toCharArray()) {
            if (current.child[c - 'a'] == null) {
                current.child[c - 'a'] = new Trie();
            }
            current.alp[c - 'a']++;
            current = current.child[c - 'a'];
        }
    }

    public int countScore(Trie root, String word, int index) {
        if (index == word.length()) return 0;
        char c = word.charAt(index);
        return root.alp[c - 'a'] + countScore(root.child[c - 'a'], word, index + 1);
    }
}
