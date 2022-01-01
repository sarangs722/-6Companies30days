public class CountSubarraysProductLessThanK {
    public static int countSubArrayProductLessThanK(long a[], long n, long k) {
        int windowStart = 0, windowEnd = 0;
        int count = 0;
        long product = 1;

        while (windowEnd < n) {
            product *= a[windowEnd];

            while ((windowStart < windowEnd) && product >= k) {
                product /= a[windowStart];
                windowStart++;
            }

            if (product < k)
                count += 1 + (windowEnd - windowStart);

            windowEnd++;
        }

        return count;
    }

    public static void main(String[] args) {
        long n = 7 , k = 100;
        long a[] = {1, 9, 2, 8, 6, 4, 3};
        System.out.println("Subarrays with product less than K : " + countSubArrayProductLessThanK(a, n, k));
    }
}
