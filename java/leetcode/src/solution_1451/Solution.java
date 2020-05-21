package solution_1451;

import java.util.ArrayList;
import java.util.List;

class Item {

    String str;
    int index;

    public Item(String str, int index) {
        this.str = str;
        this.index = index;
    }
}

public class Solution {

    public String arrangeWords(String text) {
        char[] arr = text.toCharArray();
        arr[0] += 32;
        text = new String(arr);

        String[] words = text.split(" ");
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            items.add(new Item(words[i], i));
        }
        items.sort((a, b) -> {
            if (a.str.length() == b.str.length()) {
                return a.index - b.index;
            } else {
                return a.str.length() - b.str.length();
            }
        });

        arr = items.get(0).str.toCharArray();
        arr[0] -= 32;
        StringBuilder builder = new StringBuilder(new String(arr));
        for (int i = 1; i < items.size(); i++) {
            builder.append(" ");
            builder.append(items.get(i).str);
        }
        return builder.toString();
    }
}
