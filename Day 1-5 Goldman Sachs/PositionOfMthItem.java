import javax.sound.sampled.SourceDataLine;

public class PositionOfMthItem {
    private static int findPosition(int n , int m , int k) {
        //how far from start, if less then
        if (m <= (n - k + 1))
            return (m + k - 1);
        
        //m at start
        m = m - (n - k + 1);
        
        //if more, then
        return ((m % n == 0) ? n : (m % n));
    }

    public static void main(String[] args) {
        System.out.println(findPosition(5, 8, 2));
    }
}