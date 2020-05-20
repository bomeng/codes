package solution_901;

import java.util.Stack;

public class StockSpanner {
    private Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int count = 1;
        while (!stack.isEmpty() && price >= stack.peek()[0]) {
            count = count + stack.pop()[1];
        }
        stack.push(new int[] {price, count});
        return count;
    }

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100));
        System.out.println(stockSpanner.next(80));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(70));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(75));
        System.out.println(stockSpanner.next(85));

        stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(29));
        System.out.println(stockSpanner.next(91));
        System.out.println(stockSpanner.next(62));
        System.out.println(stockSpanner.next(76));
        System.out.println(stockSpanner.next(51));
    }
}
