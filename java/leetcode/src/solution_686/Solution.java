package solution_686;

public class Solution {

    public int repeatedStringMatch(String A, String B) {
        StringBuilder builder = new StringBuilder(A);
        int count = 1;
        int b = B.length();
        while (builder.length() < b) {
            builder.append(A);
            count++;
        }
        if (builder.indexOf(B) != -1) {
            return count;
        }
        builder.append(A);
        count++;
        return builder.indexOf(B) != -1 ? count : -1;
    }
}
