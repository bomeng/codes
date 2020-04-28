import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution1036 {
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        if (blocked.length == 0)
            return true;
        Set<String> block = new HashSet<>();
        for (int i = 0; i < blocked.length; i++)
            block.add(blocked[i][0] + "->" + blocked[i][1]);
        int sx = source[0], sy = source[1], tx = target[0], ty = target[1];
        if (block.contains(sx + "->" + (sy + 1)) && block.contains(sx + "->" + (sy - 1)) && block.contains((sx + 1) + "->" + sy) && block.contains((sx - 1) + "->" + sy))
            return false;
        if (block.contains(tx + "->" + (ty + 1)) && block.contains(tx + "->" + (ty - 1)) && block.contains((tx + 1) + "->" + ty) && block.contains((tx - 1) + "->" + ty))
            return false;
        return SolveUtil(block, sx, sy, sx, sy, tx, ty, new HashSet<>());
    }

    public boolean isSafe(int x, int y) {
        return (x >= 0 && x <= 999999 && y >= 0 && y <= 999999);
    }

    public boolean SolveUtil(Set<String> block, int x, int y, int sx, int sy, int tx, int ty, Set<String> v) {
        if (sx == tx && sy == ty)
            return true;
        if (Math.abs(sx - x) + Math.abs(sy - y) > 200) return true;
        v.add(sx + "->" + sy);
        if (isSafe(sx, sy + 1) && !block.contains(sx + "->" + (sy + 1)) && !v.contains(sx + "->" + (sy + 1)))
            if (SolveUtil(block, x, y, sx, sy + 1, tx, ty, v)) return true;
        if (isSafe(sx, sy - 1) && !block.contains(sx + "->" + (sy - 1)) && !v.contains(sx + "->" + (sy - 1)))
            if (SolveUtil(block, x, y, sx, sy - 1, tx, ty, v)) return true;
        if (isSafe(sx + 1, sy) && !block.contains((sx + 1) + "->" + sy) && !v.contains((sx + 1) + "->" + sy))
            if (SolveUtil(block, x, y, sx + 1, sy, tx, ty, v)) return true;
        if (isSafe(sx - 1, sy) && !block.contains((sx - 1) + "->" + sy) && !v.contains((sx - 1) + "->" + sy))
            if (SolveUtil(block, x, y, sx - 1, sy, tx, ty, v)) return true;
        return false;
    }

    public static void main(String[] args) {
        Solution1036 solution1036 = new Solution1036();
        boolean result = solution1036.isEscapePossible(new int[][]{{691938, 300406}, {710196, 624190}, {858790, 609485}, {268029, 225806}, {200010, 188664}, {132599, 612099}, {329444, 633495}, {196657, 757958}, {628509, 883388}},
                new int[]{655988, 180910}, new int[]{267728, 840949});
        System.out.println(result);
    }
}
