package solution_443;

public class Solution {

    public int compress(char[] chars) {
        char pre = chars[0];
        int count = 1;
        int j = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == pre) {
                count++;
            } else {
                chars[j] = pre;
                j = j + 1;
                if (count > 1) {
                    char[] arr = String.valueOf(count).toCharArray();
                    for (int k = 0; k < arr.length; k++) {
                        chars[j] = arr[k];
                        j = j + 1;
                    }
                }
                pre = chars[i];
                count = 1;
            }
        }
        chars[j] = pre;
        j = j + 1;
        if (count > 1) {
            char[] arr = String.valueOf(count).toCharArray();
            for (int k = 0; k < arr.length; k++) {
                chars[j] = arr[k];
                j = j + 1;
            }
        }
        return j;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int s = solution.compress(new char[] {'a', 'a', 'b', 'b', 'c', 'c', 'c'});
        System.out.println(s);
    }
}
