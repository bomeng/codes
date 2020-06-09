package solution_680;

public class Solution {

    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        char[] arr = s.toCharArray();
        while (i < j) {
            if (arr[i] != arr[j]) {
                return isPalindrome(arr, i + 1, j) || isPalindrome(arr, i, j - 1);
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean isPalindrome(char[] arr, int left, int right) {
        while (left < right) {
            if (arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.validPalindrome("abc"));
    }
}
