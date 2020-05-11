package solution_1401;

public class Solution {

    public boolean checkOverlap(int r, int x, int y, int x1, int y1, int x2, int y2) {
        if (x >= x1 && x <= x2 && y >= y1 && y <= y2) {
            return true;
        } else if (x >= x1 && x <= x2) {
            return y1 - y > 0 && y1 - y <= r || y - y2 > 0 && y - y2 <= r;
        } else if (y >= y1 && y <= y2) {
            return x1 - x > 0 && x1 - x <= r || x - x2 > 0 && x - x2 <= r;
        } else {
            return (x - x1) * (x - x1) + (y - y1) * (y - y1) <= r * r ||
                    (x - x2) * (x - x2) + (y - y1) * (y - y1) <= r * r ||
                    (x - x1) * (x - x1) + (y - y2) * (y - y2) <= r * r ||
                    (x - x2) * (x - x2) + (y - y2) * (y - y2) <= r * r;
        }
    }
}
