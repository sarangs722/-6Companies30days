public class SubArrayWithGivenSum {
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        // Your code here
        int index = 0;
        int a = index;
        int sum = 0;
        ArrayList<Integer> res = new ArrayList<>();
        
        while(a<arr.length){
            sum +=arr[a];
            if(sum < s){
                a++;
                continue;
            }
            if(sum > s){
                index++;
                a = index;
                sum = 0;
            } 
            if(sum == s){
                res.add(index+1);
                res.add(a+1);
                break;
            }
        }
      
        if(res.isEmpty()){
            res.add(-1);
            return res;
        }
        return res;
    }
}
