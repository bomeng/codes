package solution_1419;

public class Solution {

    public int minNumberOfFrogs(String croakOfFrogs) {
        char[] croaks = croakOfFrogs.toCharArray();
        int[] frogs = new int[4];

        int max = 0;
        int count = 0;
        for (char croak : croaks) {
            if (croak == 'c') {
                count = count + 1;
                frogs[0] = frogs[0] + 1;
            } else if (croak == 'r') {
                if (frogs[0] > 0) {
                    frogs[0] = frogs[0] - 1;
                    frogs[1] = frogs[1] + 1;
                } else {
                    return -1;
                }
            } else if (croak == 'o') {
                if (frogs[1] > 0) {
                    frogs[1] = frogs[1] - 1;
                    frogs[2] = frogs[2] + 1;
                } else {
                    return -1;
                }
            } else if (croak == 'a') {
                if (frogs[2] > 0) {
                    frogs[2] = frogs[2] - 1;
                    frogs[3] = frogs[3] + 1;
                } else {
                    return -1;
                }
            } else if (croak == 'k') {
                if (frogs[3] > 0) {
                    frogs[3] = frogs[3] - 1;
                    max = Math.max(max, count);
                    count = count - 1;
                } else {
                    return -1;
                }
            }
        }
        for (int i : frogs) {
            if (i > 0) {
                return -1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minNumberOfFrogs("croakcroa"));
    }
}
