package solution_1344;

public class Solution {

    public double angleClock(int hour, int minutes) {
        double hourDegree = 30 * (hour % 12) + minutes / 2.0;
        double minuteDegree = minutes * 6.0;
        double diff = hourDegree >= minuteDegree ? hourDegree - minuteDegree : minuteDegree - hourDegree;

        return diff > 180 ?  360 - diff: diff;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.angleClock(12, 30));
        System.out.println(solution.angleClock(3, 30));
        System.out.println(solution.angleClock(3, 15));
    }
}
