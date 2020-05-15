package solution_1073;

public class Solution {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int len1 = arr1.length - 1;
        int len2 = arr2.length - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while (len1 >= 0 || len2 >= 0 || carry != 0) {
            int sum = carry;
            if (len1 >= 0) {
                sum += arr1[len1--];
            }
            if (len2 >= 0) {
                sum += arr2[len2--];
            }
            int result = sum & 1;
            sb.append(result);
            carry = -(sum >> 1);
        }

        String s = sb.toString();
        int length = s.length() - 1;
        while (length > 0 && s.charAt(length) == '0') {
            length--;
        }
        int[] arri = new int[length + 1];
        for (int i = length; i >= 0; i--) {
            char c = s.charAt(i);
            arri[length - i] = Character.getNumericValue(c);

        }
        return arri;
    }
}
