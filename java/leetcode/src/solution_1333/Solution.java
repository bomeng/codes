package solution_1333;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        return Arrays.stream(restaurants)
                .filter(a -> a[2] >= veganFriendly && a[3] <= maxPrice && a[4] <= maxDistance)
                .sorted((a, b) -> {
                    if (a[1] != b[1]) {
                        return b[1] - a[1];
                    } else {
                        return b[0] - a[0];
                    }
                })
                .map(a -> a[0])
                .collect(Collectors.toList());
    }
}
