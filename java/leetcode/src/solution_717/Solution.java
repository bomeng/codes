package solution_717;

public class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length) {
            if (bits[i] == 0) {
                if (i == bits.length - 1) {
                    return true;
                }
                i = i + 1;
            } else {
                i = i + 2;
            }
        }
        return false;
    }
}
