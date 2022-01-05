public class FindMissingAndRepeating {
    public static int[] findTwoElement(int arr[], int n) {
        // code here
        long sum = 0;
        long squareSum = 0;
        long temp;
        for (int i = 0; i < n; i++) {
            temp = arr[i];
            sum += temp;
            sum -= (i + 1);
            squareSum += (temp * temp);
            squareSum -= ((long)(i + 1) * (long)(i + 1));
        }
        // sum = A - B
        // squareSum = A^2 - B^2 = (A - B)(A + B)
        // squareSum / sum = A + B
        squareSum /= sum;
        
        //Now we have A + B and A - B. Now, A and B
        int A = (int)((sum + squareSum) / 2);
        int B = (int)(squareSum - A);
        
        int[] res = {A, B};
        
        return res;
    }

    public static void main(String[] args) {
        int n = 3;
        int[] arr = {1, 3, 3};
        int[] ans = (findTwoElement(arr, n));
        for (Integer i: ans)
            System.out.print(i + " ");
    }
}
