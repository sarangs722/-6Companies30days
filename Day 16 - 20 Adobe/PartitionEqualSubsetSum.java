public class PartitionEqualSubsetSum {
    static int equalPartition(int N, int arr[])
    {
        // code here
        int sum=0;
        for(int i=0;i<N;i++){
            sum+=arr[i];
        }
        if(sum%2!=0) 
            return 0;
        return subsetSum(arr,N,sum/2);
    }
    
    static int subsetSum(int[] arr,int n,int sum){
        boolean[][] dp = new boolean[n+1][sum+1];
        for(int i=0;i<sum+1;i++) 
            dp[0][i]=false;
        for(int i=0;i<n+1;i++) 
            dp[i][0]=true;
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(arr[i-1]<=j) 
                    dp[i][j]=dp[i-1][j-arr[i-1]] || dp[i-1][j];
                else 
                    dp[i][j]=dp[i-1][j];
            }
        }
        if(dp[n][sum]==true) 
            return 1;
        return 0;
    }
}
