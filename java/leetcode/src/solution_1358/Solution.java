package solution_1358;

public class Solution {

    public int numberOfSubstrings(String s) {
        int sum = 0;
        int[] count = new int[3];
        int left = 0;
        char[] arr = s.toCharArray();
        for (int right = 0; right < arr.length; right++) {
            int index = arr[right] - 'a';
            count[index]++;
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                sum += arr.length - right;
                index = arr[left] - 'a';
                count[index]--;
                left++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberOfSubstrings("abcabc"));
    }
}
