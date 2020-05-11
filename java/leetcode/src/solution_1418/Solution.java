package solution_1418;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Solution {

    public List<List<String>> displayTable(List<List<String>> orders) {
        TreeMap<Integer, TreeMap<String, Integer>> map = new TreeMap<>();
        Set<String> foodItems = new TreeSet<>();

        for (List<String> order : orders) {
            Integer tableNumber = Integer.parseInt(order.get(1));
            String foodItem = order.get(2);
            foodItems.add(foodItem);
            TreeMap<String, Integer> items = map.getOrDefault(tableNumber, new TreeMap<>());
            items.put(foodItem, items.getOrDefault(foodItem, 0) + 1);
            map.put(tableNumber, items);
        }

        List<List<String>> result = new ArrayList<>();
        List<String> line = new ArrayList<>();
        line.add("Table");
        line.addAll(foodItems);
        result.add(line);
        for (Integer i : map.keySet()) {
            line = new ArrayList<>();
            line.add(String.valueOf(i));
            TreeMap<String, Integer> items = map.get(i);
            for (String foodItem : foodItems) {
                line.add(String.valueOf(items.getOrDefault(foodItem, 0)));
            }
            result.add(line);
        }
        return result;
    }
}
