import javax.sound.sampled.SourceDataLine;

public class GreatestCommonDivisorOfStrings {
    public static String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1))  
            return "";

        int gcdVal = gcd(str1.length() , str2.length());
        
        return str2.substring(0, gcdVal);
    }

    private static int gcd(int a, int b) {
        if (b == 0) 
            return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        String str1 = "ABABAB", str2 = "ABAB";
        System.out.println("GCD of strings " + str1 + " and " + str2 + " : " + gcdOfStrings(str1, str2));
    }
}
