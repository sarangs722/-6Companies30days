public class WinnerOfAnElection {
    public static String[] winner(String arr[], int n)
    {
        // add your code
         Map<String,Integer>hm=new HashMap<String,Integer>();
       String res="";
       int maxval=0;
       for(int i=0;i<n;i++)
       {
           hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
       }
       
       for(Map.Entry<String,Integer>entry:hm.entrySet())
       {
           String key=entry.getKey();
           int val=entry.getValue();
           if(val>maxval)
           {
               maxval=val;
               res=key;
           }
           else if(val==maxval && res.compareTo(key)>0)
           {
               res=key;
           }
       }
       String ans[]=new String[2];
       ans[0]=res;
       ans[1]=Integer.toString(maxval);
       return ans;
    }
}
