package solution_1334;

import java.util.Arrays;

public class Solution {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], 99999);
        }
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            int z = edge[2];
            dist[x][y] = z;
            dist[y][x] = z;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        int up = 0;

        for (int i = 0; i < dist.length; i++) {
            int count = 0;
            for (int j = 0; j < dist.length; j++) {
                int val = dist[i][j];
                if (val <= distanceThreshold && i != j) {
                    count++;
                }
            }
            if (min >= count) {
                min = count;
                up = i;
            }
        }
        return up;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int s = solution.findTheCity(4, new int[][] {{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}}, 4);
        System.out.println(s);

        int t = solution.findTheCity(5, new int[][] {{0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1}}, 2);
        System.out.println(t);

        int a = solution.findTheCity(6, new int[][] {{0, 3, 7}, {2, 4, 1}, {0, 1, 5}, {2, 3, 10}, {1, 3, 6}, {1, 2, 1}}, 417);
        System.out.println(a);
    }
}
