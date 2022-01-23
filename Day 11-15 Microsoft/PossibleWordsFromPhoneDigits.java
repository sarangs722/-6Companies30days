import java.util.*;

public class PossibleWordsFromPhoneDigits {
    static ArrayList <String> possibleWords(int a[], int N)
    {
        // your code here  
        ArrayList<String> ans = new ArrayList<String>();
        String map[] = {
            "0",
            "1",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        };
        possible(a, N, "", 0, ans, map);
        return ans;
    }
    
    static void possible(int a[], int N, String curr, int i, ArrayList<String> ans, String[] map) {
        if (i == a.length) {
            ans.add(curr);
            return;
        }
        String alpha = map[a[i]];
        for (int j = 0; j < alpha.length(); j++) {
            possible(a, N, curr + alpha.charAt(j), i+1, ans, map);
        }
    }

    public static void main(String[] args) {
        int n = 3, a[] = {2, 3, 4};
        System.out.println(possibleWords(a, n));
    }
}
