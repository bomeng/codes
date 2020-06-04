package solution_68;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<List<String>> lines = new ArrayList<>();
        List<String> line = null;
        int lineLength = 0;
        for (String word : words) {
            int len = word.length();
            if (lineLength > 0 && lineLength + 1 + len <= maxWidth) {
                line.add(word);
                lineLength = lineLength + 1 + len;
            } else {
                line = new ArrayList<>();
                lines.add(line);
                line.add(word);
                lineLength = len;
            }
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < lines.size() - 1; i++) {
            line = lines.get(i);
            lineLength = 0;
            for (String item : line) {
                lineLength = lineLength + item.length();
            }
            int index = 0;
            while (lineLength < maxWidth) {
                line.set(index, line.get(index) + " ");
                lineLength++;
                index = index + 1;
                if (index >= line.size() - 1) {
                    index = 0;
                }
            }
            StringBuilder builder = new StringBuilder(line.get(0));
            for (int j = 1; j < line.size(); j++) {
                builder.append(line.get(j));
            }
            result.add(builder.toString());
        }
        // last line
        line = lines.get(lines.size() - 1);
        StringBuilder builder = new StringBuilder(line.get(0));
        for (int i = 1; i < line.size(); i++) {
            builder.append(" ").append(line.get(i));
        }
        while (builder.length() < maxWidth) {
            builder.append(" ");
        }
        result.add(builder.toString());

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> lines = solution.fullJustify(
                new String[] {"Listen", "to", "many,", "speak", "to", "a", "few."}, 6);
        for (String line : lines) {
            System.out.println(line);
        }
    }
}
