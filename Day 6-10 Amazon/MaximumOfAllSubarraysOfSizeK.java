import java.util.*;

public class MaximumOfAllSubarraysOfSizeK {
    public static void main(String[] args) {
        System.out.println(max_of_subarrays(new int[] {1, 2, 3, 1, 4 ,5 ,2 ,3 ,6}, 9, 3).toString());
    }

    static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k)
    {
        // Your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        Deque<Integer> Qi = new LinkedList<Integer>();
        
        int i;
        for (i = 0; i < k; ++i) {
            while (!Qi.isEmpty() && arr[i] >= arr[Qi.peekLast()])
                Qi.removeLast(); 
            Qi.addLast(i);
        }

        for (; i < n; ++i) {
            res.add(arr[Qi.peek()]);

            while ((!Qi.isEmpty()) && Qi.peek() <= i - k)
                Qi.removeFirst();

            while ((!Qi.isEmpty()) && arr[i] >= arr[Qi.peekLast()])
                Qi.removeLast();
            Qi.addLast(i);
        }

        res.add(arr[Qi.peek()]);
        return res;
    }
}
