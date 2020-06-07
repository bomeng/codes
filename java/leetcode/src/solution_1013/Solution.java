package solution_1013;

public class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int value : A) {
            sum = sum + value;
        }
        if (sum % 3 != 0) {
            return false;
        }
        int sub = sum / 3;
        int sub2 = sub + sub;
        sum = 0;
        for (int i = 0; i < A.length - 2; i++) {
            sum = sum + A[i];
            if (sum == sub) {
                for (int j = i + 1; j < A.length - 1; j++) {
                    sum = sum + A[j];
                    if (sum == sub2) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canThreePartsEqualSum(new int[] {0,2,1,-6,6,-7,9,1,2,0,1}));
    }
}
