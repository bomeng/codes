package solution_1009;

public class Solution {
    public int bitwiseComplement(int N) {
        String s = Integer.toBinaryString(N);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                builder.append('1');
            } else {
                builder.append('0');
            }
        }
        return Integer.parseInt(builder.toString(), 2);
    }
}
