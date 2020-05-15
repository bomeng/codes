package solution_211;

import java.util.HashMap;
import java.util.Map;

class Node {
    Map<Character, Node> map = new HashMap<>();
    boolean isEnd;
}

public class WordDictionary {
    private final Node root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new Node();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            current.map.putIfAbsent(c, new Node());
            current = current.map.get(c);
            if (i == word.length() - 1) {
                current.isEnd = true;
            }
        }
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return search(word, root);
    }

    private boolean search(String word, Node root) {
        if (word.length() == 0) {
            return root.isEnd;
        }

        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (c == '.') {
                for (Node j : node.map.values()) {
                    boolean search = search(word.substring(i + 1), j);
                    if (search) {
                        return true;
                    }
                }
                return false;
            }
            if (!node.map.containsKey(c)) {
                return false;
            }
            node = node.map.get(c);
        }
        return node.isEnd;
    }
}