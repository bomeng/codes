package solution_605;

public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int  i = 0; i <flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                if (i - 1 >= 0 && flowerbed[i - 1] != 0) {
                    continue;
                }
                if (i + 1 < flowerbed.length && flowerbed[i+ 1] != 0) {
                    continue;
                }
                flowerbed[i] = 2;
                count++;
            }
        }
        return count >= n;
    }
}
