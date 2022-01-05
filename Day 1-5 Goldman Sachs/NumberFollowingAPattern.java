import java.util.Stack;

public class NumberFollowingAPattern {
    public static void main(String[] args) {
        System.out.println(printMinNumberForPattern("IIIDID"));
    }

    static String printMinNumberForPattern(String S){
        // code here
        String ans = "";
        int n = S.length();
        Stack<Integer> stk = new Stack<Integer>();
 
        for (int i = 0; i <= n; i++) {
            //push i+1 to stack
            stk.push(i + 1);
            //if curr == 'I' or end of string
            if (i == n || S.charAt(i) == 'I') {
                // until stack is empty
                while (!stk.empty()) {
                    // remove top element
                    ans += String.valueOf(stk.peek());
                    stk.pop();
                }
            }
        }
        
        return ans;
    }

    private static String alternatePrintMinNumberForPattern(String S){
        // code here
        int I_count = 0;
        int n = S.length();
        char[] ans = new char[n + 1];
        int I = 1;
        
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == 'I') {
                I_count++;
                ans[i] = (char)(I + '0');   
                I++;
            }
        }
        int D = I_count + 1;
        
        if (S.charAt(n - 1) == 'I') {
            ans[n] = (char)(I + '0');  
            D = I + 1;
        }
        else {
            ans[n] = (char)(D + '0');  
            D++;
        }
        for (int i = n - 1; i >= 0; i--) {
            if (S.charAt(i) == 'D') {
                ans[i] = (char)(D + '0'); 
                D++;
            }
        }
        return String.valueOf(ans);
    }
}
