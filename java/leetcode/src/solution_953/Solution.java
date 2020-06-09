package solution_953;

public class Solution {

    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < words.length - 1; i++) {
            if (compare(words[i], words[i + 1], order) > 0) {
                return false;
            }
        }
        return true;
    }

    private int compare(String a, String b, String order) {
        for (int i = 0, n = Math.min(a.length(), b.length()); i < n; i++) {
            int x = order.indexOf(a.charAt(i));
            int y = order.indexOf(b.charAt(i));
            if (x != y) {
                return x - y;
            }
        }
        return a.length() - b.length();
    }
}
