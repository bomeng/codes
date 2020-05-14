package solution_208;

import java.util.HashMap;
import java.util.Map;

class Node {

    Map<Character, Node> map;
    boolean isEnd;

    public Node() {
        map = new HashMap<>();
    }
}

public class Trie {

    final private Node root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
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

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node current = root;
        for (Character c : word.toCharArray()) {
            if (!current.map.containsKey(c)) {
                return false;
            }
            current = current.map.get(c);
        }
        return current.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node current = root;
        for (Character c : prefix.toCharArray()) {
            if (!current.map.containsKey(c)) {
                return false;
            }
            current = current.map.get(c);
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        trie.search("apple");   // returns true
        trie.search("app");     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
    }
}
