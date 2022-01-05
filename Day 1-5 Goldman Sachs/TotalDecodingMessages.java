public class TotalDecodingMessages {
    public static int CountWays(String str)
    {
        // code here
        int n = str.length();
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        //base when first dig is 0
        if (str.charAt(0) == '0')
            return 0;
            
        for (int i = 2; i <= n; i++) {
            dp[i] = 0;
            
            //if prev last digit is not 0, then till that digit also contribute
            if (str.charAt(i - 1) > '0')
                dp[i] = dp[i - 1];
            
            //if prev two digits are less than 27
            if (str.charAt(i - 2) == '1' || (str.charAt(i - 2) == '2' 
            && str.charAt(i - 1) < '7'))
                dp[i] += (dp[i - 2] % 1000000007) ;
                dp[i] = dp[i] % 1000000007;
        }
        
        return dp[n] % 1000000007;
    }

    public static void main(String[] args) {
        String str = "12519";
        System.out.println(CountWays(str));
    }
}
