public class MinimumStepsToDestination {
    static int minSteps(int D){
        // code here
        int st = 0;
        int sum = 0;
        
        while (sum < D) {
            sum += st;
            st++;
        }
        
        while((sum - D) % 2 != 0) {
            sum += st;
            st++;
        }
        
        return st - 1;
    }
}
