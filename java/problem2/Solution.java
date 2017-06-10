import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {

        String input = "{a:a1,c:c1,b:{ba:b1,bb:b2}}";

        TreeMap<String, Object> map = new TreeMap<>();
        addToMap(map, input);

        String result = printValue(map);
        System.out.println(result);
    }

    private static String printValue(TreeMap<String, Object> map) {
        String result = "";
        for (String key: map.keySet()) {
            result = result + key + ":";
            Object value = map.get(key);
            if (value instanceof String) {
                result = result + value;
            } else {
                String subOut = printValue((TreeMap<String, Object>) value);
                result = result + subOut;
            }
            result = result + ",";
        }
        if (result.endsWith(",")) {
            result = result.substring(0, result.length() - 1);
        }
        result = "{" + result + "}";
        return result;
    }

    private static void addToMap(TreeMap<String, Object> map, String input) {
        List<String> result = split(input);
        for (String item: result) {
            int index = item.indexOf(":");
            String key = item.substring(0, index);
            String value = item.substring(index + 1);
            if (value.contains("{")) {
                TreeMap<String, Object> subMap = new TreeMap<>();
                map.put(key, subMap);
                addToMap(subMap, value);
            } else {
                map.put(key, value);
            }
        }
    }

    private static List<String> split(String input) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int nest = 0;
        for (int i = 1; i < input.length() - 1; i++) {
            char ch = input.charAt(i);
            switch (ch) {
                case ',':
                    if (nest == 0) {
                        list.add(sb.toString());
                        sb.setLength(0);
                        continue;
                    }
                    break;
                case '{': ++nest; break;
                case '}': --nest; break;
            }
            sb.append(ch);
        }
        list.add(sb.toString());
        return list;
    }
}