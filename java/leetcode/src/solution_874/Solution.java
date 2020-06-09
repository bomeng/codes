package solution_874;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] directions = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
        int direction = 0;
        Set<String> set = new HashSet<>();
        for (int[] obstacle : obstacles) {
            set.add(obstacle[0] + "," + obstacle[1]);
        }
        int x = 0;
        int y = 0;
        int max = 0;
        for (int command : commands) {
            if (command == -2) {
                direction = direction + 1;
                if (direction == 4) {
                    direction = 0;
                }
            } else if (command == -1) {
                direction = direction - 1;
                if (direction == -1) {
                    direction = 3;
                }
            } else {
                for (int i = 0; i < command; i++) {
                    int a = x + directions[direction][0];
                    int b = y + directions[direction][1];
                    if (!set.contains(a + "," + b)) {
                        x = a;
                        y = b;
                    } else {
                        break;
                    }
                }
                max = Math.max(max, x * x + y * y);
            }
        }
        return max;
    }
}
