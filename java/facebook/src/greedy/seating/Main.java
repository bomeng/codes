package greedy.seating;
/*
Seating Arrangements
There are n guests attending a dinner party, numbered from 1 to n. The ith guest has a height of arr[i] inches.
The guests will sit down at a circular table which has n seats, numbered from 1 to n in clockwise order around the table. As the host, you will choose how to arrange the guests, one per seat. Note that there are n! possible permutations of seat assignments.
Once the guests have sat down, the awkwardness between a pair of guests sitting in adjacent seats is defined as the absolute difference between their two heights. Note that, because the table is circular, seats 1 and n are considered to be adjacent to one another, and that there are therefore n pairs of adjacent guests.
The overall awkwardness of the seating arrangement is then defined as the maximum awkwardness of any pair of adjacent guests. Determine the minimum possible overall awkwardness of any seating arrangement.
Signature
int minOverallAwkwardness(int[] arr)
Input
n is in the range [3, 1000].
Each height arr[i] is in the range [1, 1000].
Output
Return the minimum achievable overall awkwardness of any seating arrangement.
Example
n = 4
arr = [5, 10, 6, 8]
output = 4
If the guests sit down in the permutation [3, 1, 4, 2] in clockwise order around the table (having heights [6, 5, 8, 10], in that order), then the four awkwardnesses between pairs of adjacent guests will be |6-5| = 1, |5-8| = 3, |8-10| = 2, and |10-6| = 4, yielding an overall awkwardness of 4. It's impossible to achieve a smaller overall awkwardness.
 */
import java.io.*;
import java.util.*;
// Add any extra import statements you may need here


class Main {

    // Add any helper functions you may need here


    int minOverallAwkwardness(int[] arr) {
        // Write your code here
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int[] diff = new int[3];
                diff[0] = Math.abs(arr[i] - arr[j]);
                diff[1] = i;
                diff[2] = j;
                queue.offer(diff);
            }
        }
        Set<Integer> set = new HashSet<>(); // index
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int[] diff = queue.poll();
            int a = diff[1];
            if (!set.contains(a)) {
                addToList(list, arr[a]);
                set.add(a);
            }
            int b = diff[2];
            if (!set.contains(b)) {
                addToList(list, arr[b]);
                set.add(b);
            }
            if (set.size() == arr.length) {
                break;
            }
        }

        int max = Integer.MIN_VALUE;
        int diff = 0;
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                diff = Math.abs(list.get(0) - list.get(list.size() - 1));
            } else {
                diff = Math.abs(list.get(i) - list.get(i - 1));
            }
            max = Math.max(max, diff);
        }
        return max;
    }

    private void addToList(List<Integer> list, int h) {
        if (list.size() < 3) {
            list.add(h);
            return;
        }
        int max = Integer.MIN_VALUE;
        int a = 0;
        int b = 0;
        int diff = 0;
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                diff = Math.abs(list.get(0) - list.get(list.size() - 1));
                if (diff > max) {
                    max = Math.max(max, diff);
                    a = 0;
                    b = list.size() - 1;
                }
            } else {
                diff = Math.abs(list.get(i) - list.get(i - 1));
                if (diff > max) {
                    max = Math.max(max, diff);
                    a = i;
                    b = i - 1;
                }
            }
        }
        if (a == 0) {
            list.add(0, h);
        } else {
            list.add(a, h);
        }
    }












    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;
    void check(int expected, int output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printInteger(expected);
            System.out.print(" Your output: ");
            printInteger(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printInteger(int n) {
        System.out.print("[" + n + "]");
    }
    public void run() {
        int[] arr_1 = {5, 10, 6, 8};
        int expected_1 = 4;
        int output_1 = minOverallAwkwardness(arr_1);
        check(expected_1, output_1);

        int[] arr_2 = {1, 2, 5, 3, 7};
        int expected_2 = 4;
        int output_2 = minOverallAwkwardness(arr_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }
    public static void main(String[] args) {
        new Main().run();
    }
}
