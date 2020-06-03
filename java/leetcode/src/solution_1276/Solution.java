package solution_1276;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        // x = number of jumbo burger, y = number of small burger
        // 4x + 2y = tomatoSlices
        // x + y = cheeseSlices
        // x = (tomatoSlices / 2) - cheeseSlices
        // y = 2 * cheeseSlices - (tomatoSlices / 2)
        if (tomatoSlices % 2 == 0) {
            int a = tomatoSlices / 2;
            int x = a - cheeseSlices;
            if (x >= 0) {
                int y = 2 * cheeseSlices - a;
                if (y >= 0) {
                    return Arrays.asList(x, y);
                }
            }
        }
        return Collections.emptyList();
    }
}
