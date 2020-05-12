package solution_1366;


import java.util.Arrays;

public class Solution {

    public String rankTeams(String[] votes) {
        int numOfTeams = votes[0].length();
        int[][] ranks = new int[26][numOfTeams];

        for (String vote : votes) {
            for (int i = 0; i < numOfTeams; i++) {
                char c = vote.charAt(i);
                int index = c - 'A';
                ranks[index][i] = ranks[index][i] + 1;
            }
        }

        char[] arr = votes[0].toCharArray();
        Character[] list = new Character[numOfTeams];
        for (int i = 0; i < list.length; i++) {
            list[i] = arr[i];
        }
        Arrays.sort(list, (a, b) -> {
            int i = 0;
            while (i < numOfTeams) {
                int row1 = a - 'A';
                int row2 = b - 'A';
                if (ranks[row1][i] != ranks[row2][i]) {
                    return ranks[row2][i] - ranks[row1][i];
                } else {
                    i = i + 1;
                }
            }
            return a.compareTo(b);
        });

        StringBuilder builder = new StringBuilder();
        Arrays.stream(list).forEach(builder::append);
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.rankTeams(new String[] {"ABC", "ACB", "ABC", "ACB", "ACB"});
        System.out.println(s);
        s = solution.rankTeams(new String[] {"WXYZ", "XYZW"});
        System.out.println(s);
    }
}
