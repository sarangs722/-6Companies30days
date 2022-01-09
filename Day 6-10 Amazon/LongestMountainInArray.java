public class LongestMountainInArray {
    public static void main(String[] args) {
        int[] arr = {2,1,4,7,3,2,5};
        System.out.println(longestMountain(arr));
    }

    public static int longestMountain(int[] arr) {
        int n = arr.length;
        if (n < 3)
            return 0;
        
        int i = 0, j, maxi = 0;
        
        //n - 2 bcoz length should be atleast 3 for mountain subarray
        while (i < n - 2) {
            //skipping descending subarray
            while (i < n - 1 && arr[i] >= arr[i + 1]) {
                i++;
            }
            j = i + 1;
            
            //uppar jaa raha, mountain up
            while (j < n - 1 && arr[j] < arr[j + 1]) {
                j++;
            }
            
            //at mountain top, now descending to down
            while (j < n - 1 && arr[j] > arr[j + 1]) {
                j++;
                maxi = Math.max(maxi, j - i + 1);
            }
            
            //looking for more mountain subarrays
            i = j;
        } 
        return maxi;
    }
}
