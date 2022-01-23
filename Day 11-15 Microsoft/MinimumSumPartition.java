import java.util.*;

public class MinimumSumPartition {
    private static int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	    int sum = 0;
	    for(int i = 0 ; i < n ; i++){
	        sum += arr[i];
	    }
	   
	    ArrayList<Integer> data =  isSubsetSum(arr, sum , n);
	    int minimum = Integer.MAX_VALUE;
	    
	    for(int i=0 ; i<data.size() ; i++){
	        minimum = Math.min(minimum , sum - 2 * data.get(i));
	    }
	    return minimum;
	}
	
	private static ArrayList<Integer> isSubsetSum(int arr[] , int sum , int n){
	    
	    boolean dp[][] = new boolean[n+1][sum+1];
	    for(int i = 0 ; i < n + 1; i++){
	        for(int j = 0; j < sum + 1; j++){
	            if(i == 0)
	                dp[i][j] = false;
	               
	            if(j == 0)
	                dp[i][j] = true;
	        }
	    }
	    for(int i = 1 ; i < n + 1; i++){
	        for(int j = 1; j < sum + 1; j++){
	            
	            if(arr[i - 1] <= j){
	                dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
	            }
	            else
	                dp[i][j] = dp[i - 1][j];
	        }
	    }
	    ArrayList<Integer> half = new ArrayList<>();
	    for(int j = 0; j <= sum/2; j++){
	        if(dp[n][j] == true)
	            half.add(j);
	    }
	    return half;
	} 

    public static void main(String[] args) {
        int n = 4, arr[] = {1, 6, 11, 5};
        System.out.println(minDifference(arr, n));
    }
}
