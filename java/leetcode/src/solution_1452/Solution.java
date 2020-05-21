package solution_1452;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        Set<?>[] sets = new HashSet<?>[favoriteCompanies.size()];
        for (int i = 0; i < sets.length; i++) {
            sets[i] = new HashSet<>(favoriteCompanies.get(i));
        }

        for (int i = 0; i < sets.length - 1; i++) {
            if (sets[i].size() == 0) {
                continue;
            }
            for (int j = i + 1; j < sets.length; j++) {
                if (sets[j].size() == 0) {
                    continue;
                }
                if (sets[j].containsAll(sets[i])) {
                    sets[i].clear();
                } else if (sets[i].containsAll(sets[j])) {
                    sets[j].clear();
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < sets.length; i++) {
            if (sets[i].size() != 0) {
                result.add(i);
            }
        }

        return result;
    }
}
