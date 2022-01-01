public class OverlappingRectangles {
    private static int doOverlap(int L1[], int R1[], int L2[], int R2[]) {
        // code here
        /*
        a point lies inside a rectangle, if 
        x coordinate lies between TopLeft point's x and BottomRight point's x
        and 
        y coordinate lies between TopLeft point's y and BottomRight point's y
        */
        
        //If not even a line, then can't overlap obviously
        // if (L1[0] == R1[0] || L1[1] == R1[1] || L2[0] == R2[0] || L2[1] == R2[1])
        //     return 0;
            
        //checking left
        if (L2[0] > R1[0] || L1[0] > R2[0])
            return 0;
            
        //checking top
        if (R1[1] > L2[1] || R2[1] > L1[1])
            return 0;
        
        //in all other cases, overlaps
        return 1;
    }

    public static void main(String[] args) {
        int[] L1 = {0,2};
        int[] R1 = {1,1};
        int[] L2 = {-2,-3};
        int[] R2 = {0,2};

        System.out.println("Overlapping or not? " + doOverlap(L1, R1, L2, R2));
    }
}