package solution_721;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<Set<String>>> map = new HashMap<>();
        for (List<String> account : accounts) {
            String name = account.get(0);
            Set<String> emails = new HashSet<>(account.subList(1, account.size()));

            Set<String> newEmails = new HashSet<>(emails);
            List<Set<String>> list = map.getOrDefault(name, new ArrayList<>());
            for (int i = list.size() - 1; i >= 0; i--) {
                Set<String> item = list.get(i);
                for (String email : emails) {
                    if (item.contains(email)) {
                        newEmails.addAll(item);
                        list.remove(item);
                        break;
                    }
                }
            }
            list.add(newEmails);
            map.put(name, list);
        }
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<Set<String>>> entry : map.entrySet()) {
            for (Set<String> set : entry.getValue()) {
                List<String> line = set.stream().sorted().collect(Collectors.toList());
                line.add(0, entry.getKey());
                result.add(line);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> list = new ArrayList<>();
        List<String> item1 = new ArrayList<>();
        item1.add("John");
        item1.add("johnsmith@mail.com");
        item1.add("john_newyork@mail.com");
        list.add(item1);
        List<String> item2 = new ArrayList<>();
        item2.add("John");
        item2.add("johnsmith@mail.com");
        item2.add("johnsmith@mail.com");
        list.add(item2);
        List<String> item3 = new ArrayList<>();
        item3.add("Mary");
        item3.add("mary@mail.com");
        list.add(item3);
        List<String> item4 = new ArrayList<>();
        item4.add("John");
        item4.add("johnnybravo@mail.com");
        list.add(item4);
        List<List<String>> result = solution.accountsMerge(list);
        System.out.println(result);
    }
}
