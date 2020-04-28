public class Solution925 {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0;
        int j = 0;

        while (i < name.length() && j < typed.length()) {
            if (name.charAt(i) != typed.charAt(j)) {
                return false;
            }
            i = i + 1;
            j = j + 1;
            if (i < name.length() && name.charAt(i) == name.charAt(i - 1)) {
                while (j < typed.length() && typed.charAt(j) == typed.charAt(j - 1)) {
                    j = j + 1;
                }
            }
        }

        if (i == name.length() && j == typed.length()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Solution925 solution925 = new Solution925();
        solution925.isLongPressedName("vtkgn", "vttkgnn");
    }
}
