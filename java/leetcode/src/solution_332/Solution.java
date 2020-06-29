package solution_332;

import java.util.*;

public class Solution {


    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        List<String> res = new LinkedList<>();

        //1. Build Graph
        for (List<String> ticket : tickets) {
            String from = ticket.get(0), to = ticket.get(1);
            if (!graph.containsKey(from)) graph.put(from, new PriorityQueue<>());

            graph.get(from).offer(to);
        }

        //2. Call DFS from JFK
        dfs("JFK", graph, res);
        return res;
    }

    void dfs(String from, Map<String, PriorityQueue<String>> graph, List<String> res) {
        PriorityQueue<String> arrivals = graph.get(from);
        while (arrivals != null && !arrivals.isEmpty()) {
            dfs(arrivals.poll(), graph, res);
        }

        res.add(0, from);
    }
}
