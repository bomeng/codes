package solution_380;

import java.util.*;

class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> list;
    Random random;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        list.add(val);
        int lastIndex = list.size() - 1;
        map.put(val, lastIndex);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int removeIndex = map.get(val);
        int lastIndex = list.size() - 1;
        int temp = list.get(lastIndex);
        list.set(removeIndex, temp);
        map.put(temp, removeIndex);
        list.remove(lastIndex);
        map.remove(val);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int size = list.size();
        int index = random.nextInt(size);
        return list.get(index);
    }
}

public class Solution {
    public static void main(String[] args) {
        RandomizedSet obj = new RandomizedSet();
        obj.insert(0);
        obj.insert(1);
        obj.remove(0);
        obj.insert(2);
        obj.remove(1);
        System.out.println(obj.getRandom());
    }
}
