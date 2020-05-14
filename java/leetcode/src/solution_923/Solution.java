package solution_923;

public class Solution {
    public int threeSumMulti(int[] A, int target) {
        int count = 0;
        for (int i = 0; i < A.length - 2; i++) {
            int a = A[i];
            int low = i + 1;
            int high = A.length - 1;
            int t = target - a;
            if (t < 0) {
                continue;
            }
            count = count + find(A, low, high, t);
            count = count % 1000000007;
        }
        return count;
    }

    private int find(int[] arr, int low, int high, int target) {
        int[] map = new int[101];
        int count = 0;
        for (int i = low; i <= high; i++) {
            int index = target - arr[i];
            if (index >= 0 && index < map.length) {
                count = count + map[index];
            }
            map[arr[i]] = map[arr[i]] + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.threeSumMulti(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5}, 8));
        System.out.println(solution.threeSumMulti(new int[]{3, 3, 1}, 7));
    }
}
