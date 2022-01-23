public class SticklerTheif {
    public static int FindMaxSum(int arr[], int n)
    {
        // Your code here
        int[] b = new int[n];
        if(n==1) 
            return arr[0];
        if(n==2) 
            return Math.max(arr[0],arr[1]);
        b[0] = arr[0];
        b[1] = Math.max(arr[0],arr[1]);
        
        for(int i = 2;i<n;i++) 
            b[i] = Math.max(b[i-1],b[i-2]+arr[i]);
        return b[n-1];
    }

    public static void main(String[] args) {
        int n = 6, a[] = {5,5,10,100,10,5};
        System.out.println(FindMaxSum(a, n));
    }
}
