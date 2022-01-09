public class MaximumProfit {
    public static void main(String[] args) {
        System.out.println(maxProfit(2, 6, new int[]{10,22,5,75,65,80}));
    }

    private static int maxProfit(int K, int N, int A[]) {
        // code here
        int[][] profit = new int[K + 1][N];
        
        //day 0
        for (int i = 0; i <= K; i++)
            profit[i][0] = 0;
        
        //k 0 transactions
        for (int j = 0; j < N; j++)
            profit[0][j] = 0;
            
        int i, j;
        //i = k, j = days
        
        for (i = 1; i <= K; i++) {
            int prevMaxDiff = Integer.MIN_VALUE;
            
            for (j = 1; j < N; j++) {
                prevMaxDiff = Math.max(prevMaxDiff, profit[i - 1][j - 1] - A[j - 1]);
                profit[i][j] = Math.max(profit[i][j - 1], prevMaxDiff + A[j]);
            }
        }
        
        return profit[K][N - 1];
    }
}
