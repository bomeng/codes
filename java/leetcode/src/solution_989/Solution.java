package solution_989;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> addToArrayForm(int[] A, int K) {
        char[] B = String.valueOf(K).toCharArray();
        int i = A.length - 1;
        int j = B.length - 1;
        int k = 0;
        List<Integer> list = new ArrayList<>();
        while (i >=0 && j >= 0) {
            int s = A[i] + (B[j] - '0') + k;
            list.add( s % 10);
            k = s / 10;
            i--;
            j--;
        }
        while (i >= 0) {
            int s = A[i] + k;
            list.add(s % 10);
            k = s / 10;
            i--;
        }
        while (j >= 0) {
            int s = (B[j] - '0') + k;
            list.add( s % 10);
            k = s / 10;
            j--;
        }
        if (k > 0) {
            list.add(k);
        }
        i = 0;
        j = list.size() - 1;
        while (i < j) {
            int temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
            i++;
            j--;
        }
        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addToArrayForm(new int[] {1, 2, 0, 0}, 34));
        System.out.println(solution.addToArrayForm(new int[] {0}, 0));
    }
}
