package solution_1487;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String[] getFolderNames(String[] names) {
        String[] res = new String[names.length];
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < names.length; i++) {
            if (map.containsKey(names[i])) {
                StringBuilder sb = new StringBuilder();
                int k = map.get(names[i]);
                do {
                    sb = new StringBuilder(names[i]);
                    sb.append("(");
                    sb.append(k++);
                    sb.append(")");
                } while (map.containsKey(sb.toString()));
                map.put(names[i], k);
                map.put(sb.toString(), 1);
                res[i] = sb.toString();
            } else {
                map.put(names[i], 1);
                res[i] = names[i];
            }
        }
        return res;
    }
}
