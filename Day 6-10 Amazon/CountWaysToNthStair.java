public class CountWaysToNthStair {
    static Long countWays(int m)
    {
        // your code here
        return (long)(1 + (m / 2));
    } 

    public static void main(String[] args) {
        System.out.println(countWays(4));
    }
}
