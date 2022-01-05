import java.util.HashMap;

public class ArrayPairSumDivisibilityProblem {
    public static void main(String[] args) {
        int[] nums = {9,5,7,3};
        int k = 6;
        System.out.println(canPair(nums, k));
    }

    public static boolean canPair(int[] nums, int k) {
        // Code here
        int n = nums.length;
        if (n % 2 != 0)
            return false;

        // of all remainders when divided by k.
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        // occurrences of all remainders
        for (int i = 0; i < n; i++) {
            int rem = ((nums[i] % k) + k) % k;
            if (!map.containsKey(rem)) {
                map.put(rem, 0);
            }
            map.put(rem, map.get(rem) + 1);
        }

        // use freq[] to decide
        // if given array can be divided in pairs
        for (int i = 0; i < n; i++) {
            // Remainder of current element
            int rem = ((nums[i] % k) + k) % k;
            // If remainder with current element divides
            // k into two halves.
            if (k == (2 * rem)) {
                // Then there must be even occurrences of
                // such remainder
                if (map.get(rem) % 2 == 1)
                    return false;
            }

            // If remainder is 0, then there must be two
            // elements with 0 remainder
            else if (rem == 0) {
                // Then there must be even occurrences of
                // such remainder
                if (map.get(rem) % 2 == 1)
                    return false;
            }

            // Else number of occurrences of remainder
            // must be equal to number of occurrences of
            // k - remainder
            else {
                if (map.get(k - rem) != map.get(rem))
                    return false;
            }
        }
        return true;
    }
}
