import java.util.Arrays;

public class RotateBy90 {
    private static void rotate(int matrix[][]) 
    {
        // Code Here
        var rotatedMatrix = new int[matrix.length][matrix.length];
              
        for(var i=0;i<matrix.length;i++) {
            for(var j=0;j<matrix.length;j++) { 
                rotatedMatrix[i][j] = matrix[j][matrix.length-1-i];
            }
        }
        
        for(var i=0;i<matrix.length;i++) {
            for(var j=0;j<matrix.length;j++) { 
                matrix[i][j] = rotatedMatrix[i][j];
            }
        }
    }

    public static void main(String[] args) {
        int [][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(arr);

        for (int[] i: arr)
            System.out.println(Arrays.toString(i));
    }
}
