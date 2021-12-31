public class RunLengthEncoding {
    private static String encode(String str) {
        // Your code here
        String ans = "";
        for (int i = 0; i < str.length(); i++) {
            ans += str.charAt(i);
            int count = 1;
            while ((i + 1 < str.length()) && (str.charAt(i + 1) == str.charAt(i))) {
                i++;
                count++;
            }
            ans += String.valueOf(count);
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "aaaabbbccc";
        System.out.println(encode(str));
    }
}