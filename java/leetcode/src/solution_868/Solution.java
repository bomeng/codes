package solution_868;

public class Solution {
    public int binaryGap(int N) {
        int max = 0;
        int pre = -1;
        int index = 0;
        while (N != 0) {
            int a = N % 2;
            if (a == 1) {
                if (pre != -1) {
                    max = Math.max(max, index - pre);
                }
                pre = index;
            }
            index++;
            N = N / 2;
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.binaryGap(22));
    }
}
