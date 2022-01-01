public class UglyNumbers {
    private static long getNthUglyNo(int n) {
        // code here
        int p2 = 0, p3 = 0, p5 = 0;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        long two, three, five;
        
        for (int i = 1; i <= n; i++) {
            two = 2 * dp[p2];
            three = 3 * dp[p3];
            five = 5 * dp[p5];
            
            dp[i] = Math.min(two, Math.min(three, five));
            if (two == dp[i])
                p2++;
            if (three == dp[i])
                p3++;
            if (five == dp[i])
                p5++;
        }
        
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(n + "th Ugly Number is: " + getNthUglyNo(n));
    }
}
