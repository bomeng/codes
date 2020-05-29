package solution_1328;

public class Solution {
    public String breakPalindrome(String palindrome) {
        char[] arr = palindrome.toCharArray();
        if (arr.length == 1) {
            return "";
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 'a') {
                char temp = arr[i];
                arr[i] = 'a';
                if (!isPelindrome(arr)) {
                    return new String(arr);
                } else {
                    arr[i] = temp;
                }
            }
        }
        char c = arr[arr.length - 1];
        c += 1;
        arr[arr.length - 1] = c;
        return new String(arr);
    }

    boolean isPelindrome(char[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] != arr[arr.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.breakPalindrome("abccba"));
        System.out.println(solution.breakPalindrome("a"));
        System.out.println(solution.breakPalindrome("bbb"));
    }
}
