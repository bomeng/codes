package solution_1306;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean canReach(int[] arr, int start) {
        Set<Integer> visited = new HashSet<>();
        return helper(arr, start, visited);
    }

    private boolean helper(int[] arr, int start, Set<Integer> visited) {
        if (visited.size() == arr.length || start < 0 || start > arr.length - 1 || visited.contains(start)) {
            return false;
        }
        visited.add(start);
        if (arr[start] == 0) {
            return true;
        }
        return helper(arr, start - arr[start], visited) || helper(arr, start + arr[start], visited);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean result = solution.canReach(new int[] {3,0,2,1,2}, 5);
        System.out.println(result);
    }
}
