package solution_447;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            map.clear();
            for (int j = 0; j < points.length; j++) {
                int a = points[i][0] - points[j][0];
                int b = points[i][1] - points[j][1];
                int dist = a * a + b * b;
                int count = map.getOrDefault(dist, 0);
                result = result + 2 * count;
                map.put(dist, count + 1);
            }
        }
        return result;
    }
}
