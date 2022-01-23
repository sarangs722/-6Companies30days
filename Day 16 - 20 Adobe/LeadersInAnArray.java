public class LeadersInAnArray {
    static ArrayList<Integer> leaders(int arr[], int n){
        // Your code here
        ArrayList<Integer> lead = new ArrayList();
       int max=0;
       for(int i = arr.length-1 ; i>=0 ; i-- )
       {
           if(max<=arr[i])
           {
               max=arr[i];
               lead.add(max);
           }
       }
       Collections.reverse(lead);
       return lead;      
    }
}
