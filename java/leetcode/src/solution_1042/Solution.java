package solution_1042;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public int[] gardenNoAdj(int N, int[][] paths) {
        int[] flower = new int[N];
        ArrayList<Integer>[] map = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            map[i] = new ArrayList<>();
        }
        for (int[] path : paths) {
            map[path[0] - 1].add(path[1] - 1);
            map[path[1] - 1].add(path[0] - 1);
        }
        for (int i = 0; i < N; i++) {
            List<Integer> connected = map[i];
            Set<Integer> flowers = new HashSet<>();
            for (int j : connected) {
                if (flower[j] > 0) {
                    flowers.add(flower[j]);
                }
            }
            for (int j = 1; j <= 4; j++) {
                if (!flowers.contains(j)) {
                    flower[i] = j;
                    break;
                }
            }
        }
        return flower;
    }
}
