import java.util.*;

public class StockSpanProblem {
    public static int[] calculateSpan(int arr[], int n)
    {
        // Your code here]
        int span[] = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        span[0] = 1;
        for(int i = 1; i < n; i++) {
           while(!st.empty() && arr[i]>=arr[st.peek()]) {
               st.pop();
           }
           
           if(st.size()==0) {
               span[i] = i+1;
           }
           
           else {
               span[i] = i-st.peek();
           }
           st.push(i);
       }
       return span;
    }

    public static void main(String[] args) {
        int n = 7, price[] = {100,80,60,70,60,75,85};
        System.out.println(Arrays.toString(calculateSpan(price, n)));
    }
}
