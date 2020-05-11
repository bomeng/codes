package solution_1414;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int findMinFibonacciNumbers(int k) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        int a = list.get(list.size() - 1) + list.get(list.size() - 2);
        while (a <= k) {
            list.add(a);
            a = list.get(list.size() - 1) + list.get(list.size() - 2);
        }
        int count = 0;
        k = k - list.get(list.size() - 1);
        while (k > 0) {
            count = count + 1;
            while (list.get(list.size() - 1) > k) {
                list.remove(list.size() - 1);
            }
            k = k - list.get(list.size() - 1);
        }
        count = count + 1;
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.findMinFibonacciNumbers(19);
        System.out.println(i);
    }
}
