package solution_1138;


public class Solution {

    public String alphabetBoardPath(String target) {
        int startX = 0;
        int startY = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            int index = c - 'a';
            int endX = index / 5;
            int endY = index % 5;
            findPath(startX, startY, endX, endY, builder);
            startX = endX;
            startY = endY;
        }

        return builder.toString();
    }

    private void findPath(int startx, int starty, int endx, int endy, StringBuilder builder) {
        while (startx != endx || starty != endy) {
            if (startx < endx) {
                if (startx != 4 || starty == 0) {
                    startx++;
                    builder.append('D');
                }
            }
            if (startx > endx) {
                builder.append('U');
                startx--;
            }
            if (starty < endy) {
                if (startx != 5) {
                    builder.append('R');
                    starty++;
                }
            }
            if (starty > endy) {
                builder.append('L');
                starty--;
            }
        }
        builder.append('!');
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.alphabetBoardPath("zdz"));
    }
}
